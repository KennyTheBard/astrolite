package com.impaler.astrolite.service;

import com.impaler.astrolite.model.combat.*;
import com.impaler.astrolite.repository.AttackFleetRepository;
import com.impaler.astrolite.repository.DefenceFleetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CombatService {

    @Autowired
    private AttackFleetRepository attackFleetRepository;

    @Autowired
    private DefenceFleetRepository defenceFleetRepository;

    public void resolveCombat(List<Long> attackFleetsID, List<Long> defenceFleetsID) {
        List<AttackFleet> attackFleets = attackFleetRepository.findAllById(attackFleetsID);
        List<DefenceFleet> defenceFleets = defenceFleetRepository.findAllById(defenceFleetsID);

        // get all ShipToFleet objects
        List<IFleetShip> shipToFleets = new ArrayList<>();
        attackFleets.stream()
                .map(AttackFleet::getShips)
                .forEach(shipToFleets::addAll);
        defenceFleets.stream()
                .map(DefenceFleet::getShips)
                .forEach(shipToFleets::addAll);

        // group by attack speed of offensive stats in order to synchronise attacks of the ships with same attack speed
        Map<Integer, List<Pair<OffensiveStats, IFleetShip>>> combatGroups = new HashMap<>();
        shipToFleets.forEach(fleetShip -> {
            fleetShip.getShip().getOffensiveStats()
                    .forEach(of -> {
                        if (!combatGroups.containsKey(of.getAttackSpeed())) {
                            combatGroups.put(of.getAttackSpeed(), new ArrayList<>());
                        }
                        combatGroups.get(of.getAttackSpeed()).add(Pair.of(of, fleetShip));
                    });
        });

        // calculate damage taking into consideration turn order
        Queue<Pair<Integer, List<Pair<OffensiveStats, IFleetShip>>>> combatOrder = new PriorityQueue<>(Comparator.comparingInt(Pair::getFirst));
        combatOrder.addAll(combatGroups.entrySet().stream().map(e -> Pair.of(e.getKey(), e.getValue())).collect(Collectors.toList()));
        while (!hasEnded(attackFleets, defenceFleets)) {
            Pair<Integer, List<Pair<OffensiveStats, IFleetShip>>> currentAttackers = combatOrder.poll();

            // calculate damage dealt by each side
            Map<DamageType, Long> attackerTurnDamage = new HashMap<>();
            Map<DamageType, Long> defenderTurnDamage = new HashMap<>();
            currentAttackers.getSecond().forEach(p -> {
                Map<DamageType, Long> turnDamage = attackFleetsID.contains(p.getSecond().getFleet().getId()) ? attackerTurnDamage : defenderTurnDamage;

                Long currentValue = turnDamage.getOrDefault(p.getFirst().getDamageType(), 0L);
                turnDamage.put(p.getFirst().getDamageType(), currentValue + (long) (p.getFirst().getAttackDamage() * p.getSecond().getQuantity()));
            });

            // apply damage dealt by each side
            applyDamageToFleets(attackFleets.stream().flatMap(f -> f.getShips().stream()).collect(Collectors.toList()), defenderTurnDamage);
            applyDamageToFleets(defenceFleets.stream().flatMap(f -> f.getShips().stream()).collect(Collectors.toList()), attackerTurnDamage);

            combatOrder.add(
                    Pair.of(
                            currentAttackers.getFirst() + currentAttackers.getSecond().get(0).getFirst().getAttackSpeed(),
                            currentAttackers.getSecond().stream().filter(s -> s.getSecond().getQuantity() > 0).collect(Collectors.toList())
                    )
            );
        }

    }

    private void applyDamageToFleets(List<? extends IFleetShip> fleetShips, Map<DamageType, Long> turnDamage) {
        long totalHealth = fleetShips.stream().mapToLong(s -> s.getQuantity() * s.getShip().getHealth()).sum();
        List<Pair<Double, ? extends IFleetShip>> percentsOfTotalHealth = new ArrayList<>();
        fleetShips.forEach(s -> percentsOfTotalHealth.add(Pair.of((double) (s.getQuantity() * s.getShip().getHealth()) / totalHealth, s)));

        for (Pair<Double, ? extends IFleetShip> p : percentsOfTotalHealth) {
            Map<DamageType, Integer> defences = p.getSecond().getShip().getDefensiveStats().stream()
                    .collect(Collectors.toMap(DefensiveStats::getAgainst, DefensiveStats::getArmor));

            for (Map.Entry<DamageType, Long> turnDamageByType : turnDamage.entrySet()) {
                Double defenceModifier = calculateDamageReduction(defences.getOrDefault(turnDamageByType.getKey(), 0));
                Long takenDamage = (long) (turnDamageByType.getValue() * p.getFirst() * defenceModifier);
                p.getSecond().destroyShips((int) (takenDamage / p.getSecond().getShip().getHealth()));
            }
        }
    }

    private boolean hasEnded(List<AttackFleet> attackFleets, List<DefenceFleet> defenceFleets) {
        boolean attackEnded = attackFleets.stream()
                .map(AttackFleet::defeated)
                .reduce(Boolean::logicalAnd)
                .orElse(true);

        boolean defenceDefeated = defenceFleets.stream()
                .map(DefenceFleet::defeated)
                .reduce(Boolean::logicalAnd)
                .orElse(true);

        return attackEnded || defenceDefeated;
    }

    private Double calculateDamageReduction(Integer armor) {
        return 100.0 / (100.0 + armor);
    }

}
