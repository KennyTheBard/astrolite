CREATE TABLE player (
    id bigserial PRIMARY KEY,
    name VARCHAR(32) UNIQUE NOT NULL
);

CREATE TABLE resource (
    id bigserial PRIMARY KEY,
    name VARCHAR(32) UNIQUE NOT NULL
);

CREATE TABLE solar_system (
    id bigserial PRIMARY KEY,
    name VARCHAR(32) NOT NULL,
    distance_to_core integer NOT NULL,
    angle_to_core integer NOT NULL
);

CREATE TABLE solar_system_resource_modifier (
    resource_id bigint NOT NULL REFERENCES resource(id),
    solar_system_id bigint NOT NULL REFERENCES solar_system(id),
    modifier real NOT NULL,
    PRIMARY KEY (resource_id, solar_system_id)
);

CREATE TABLE colony (
    id bigserial PRIMARY KEY,
    name VARCHAR(32) NOT NULL,
    solar_system_id bigint NOT NULL REFERENCES solar_system(id),
    owner_id bigint NOT NULL REFERENCES player(id),
    max_resource_inventory integer NOT NULL
);

CREATE TABLE colony_resource_inventory (
    resource_id bigint NOT NULL REFERENCES resource(id),
    colony_id bigint NOT NULL REFERENCES colony(id),
    quantity real NOT NULL,
    last_resource_interrogation timestamp NOT NULL,
    PRIMARY KEY (resource_id, colony_id)
);

CREATE TABLE colony_resource_production (
    resource_id bigint NOT NULL REFERENCES resource(id),
    colony_id bigint NOT NULL REFERENCES colony(id),
    production_per_second real NOT NULL,
    PRIMARY KEY (resource_id, colony_id)
);

CREATE TABLE building (
    id bigserial PRIMARY KEY,
    name VARCHAR(32) NOT NULL,
    max_level integer NOT NULL
);

CREATE TABLE building_resource_cost (
    resource_id bigint NOT NULL REFERENCES resource(id),
    building_id bigint NOT NULL REFERENCES building(id),
    cost integer NOT NULL,
    PRIMARY KEY (resource_id, building_id)
);

CREATE TABLE colony_building (
    id bigserial PRIMARY KEY,
    building_id bigint NOT NULL REFERENCES building(id),
    colony_id bigint NOT NULL REFERENCES colony(id),
    current_level integer NOT NULL
);

CREATE TABLE ship (
    id bigserial PRIMARY KEY,
    name varchar(32) NOT NULL,
    build_at bigint NOT NULL REFERENCES building(id),
    build_time_sec integer NOT NULL,
    travel_speed integer NOT NULL,
    health integer NOT NULL,
    inventory integer NOT NULL
);

CREATE TABLE damage_type (
    id bigserial PRIMARY KEY,
    name VARCHAR(32) UNIQUE NOT NULL
);

CREATE TABLE ship_resource_cost (
    resource_id bigint NOT NULL REFERENCES resource(id),
    ship_id bigint NOT NULL REFERENCES ship(id),
    cost integer NOT NULL,
    PRIMARY KEY (resource_id, ship_id)
);

CREATE TABLE offensive_stats (
    id bigserial PRIMARY KEY,
    owner_id bigint NOT NULL REFERENCES ship(id),
    attack_damage integer NOT NULL,
    damage_type_id bigint NOT NULL REFERENCES damage_type(id),
    attack_speed integer NOT NULL
);

CREATE TABLE defensive_stats (
    id bigserial PRIMARY KEY,
    owner_id bigint NOT NULL REFERENCES ship(id),
    armor integer NOT NULL,
    damage_type_id bigint NOT NULL REFERENCES damage_type(id)
);

CREATE TABLE defence_fleet (
    id bigserial PRIMARY KEY,
    owner_id bigint NOT NULL REFERENCES player(id),
    stationed_at bigint NOT NULL REFERENCES solar_system(id)
);

CREATE TABLE defence_fleet_ship (
    ship_id bigint NOT NULL REFERENCES ship(id),
    fleet_id bigint NOT NULL REFERENCES defence_fleet(id),
    quantity integer NOT NULL,
    PRIMARY KEY (ship_id, fleet_id)
);

CREATE TABLE attack_fleet (
    id bigserial PRIMARY KEY,
    owner_id bigint NOT NULL REFERENCES player(id),
    send_from bigint NOT NULL REFERENCES solar_system(id),
    send_to bigint NOT NULL REFERENCES solar_system(id),
    travel_speed integer NOT NULL
);

CREATE TABLE attack_fleet_loot (
    resource_id bigint NOT NULL REFERENCES resource(id),
    attack_fleet_id bigint NOT NULL REFERENCES attack_fleet(id),
    quantity integer NOT NULL,
    PRIMARY KEY (resource_id, attack_fleet_id)
);

CREATE TABLE attack_fleet_ship (
    ship_id bigint NOT NULL REFERENCES ship(id),
    fleet_id bigint NOT NULL REFERENCES attack_fleet(id),
    quantity integer NOT NULL,
    PRIMARY KEY (ship_id, fleet_id)
);

CREATE TABLE research (
    id bigserial PRIMARY KEY,
    name varchar(32) NOT NULL,
    research_at bigint NOT NULL REFERENCES building(id),
    research_time_sec integer NOT NULL
);

CREATE TABLE research_resource_cost (
    resource_id bigint NOT NULL REFERENCES resource(id),
    research_id bigint NOT NULL REFERENCES research(id),
    cost integer NOT NULL,
    PRIMARY KEY (resource_id, research_id)
);

CREATE TABLE bonus (
    id bigserial PRIMARY KEY,
    name varchar(32) NOT NULL,
    research_id bigint NOT NULL REFERENCES research(id),
    bonus_type integer NOT NULL, -- add, multiply, subtract, divide
    bonus_value integer NOT NULL
);

CREATE TABLE research_player (
    player_id bigint NOT NULL REFERENCES player(id),
    research_id bigint NOT NULL REFERENCES research(id),
    PRIMARY KEY (player_id, research_id)
);

CREATE TABLE constraint_ship (
    required_research_id  bigint NOT NULL REFERENCES research(id),
    ship_id bigint NOT NULL REFERENCES ship(id),
    PRIMARY KEY (required_research_id, ship_id)
);

CREATE TABLE constraint_research (
    required_research_id bigint NOT NULL REFERENCES research(id),
    research_id bigint NOT NULL REFERENCES research(id),
    PRIMARY KEY (required_research_id, research_id)
);

CREATE TABLE ship_execution_request (
    id bigserial PRIMARY KEY,
    request_creation_time timestamp NOT NULL,
    colony_building_id bigint NOT NULL REFERENCES colony_building(id),
    ship_id bigint NOT NULL REFERENCES ship(id),
    quantity integer NOT NULL
);

CREATE TABLE research_execution_request (
    id bigserial PRIMARY KEY,
    request_creation_time timestamp NOT NULL,
    colony_building_id bigint NOT NULL REFERENCES colony_building(id),
    research_id bigint NOT NULL REFERENCES research(id)
);