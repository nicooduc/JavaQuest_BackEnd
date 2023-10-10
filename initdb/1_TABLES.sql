create table hero
(
    id SERIAL PRIMARY KEY,
    name TEXT not null,
    image bytea null,
    level int not null,
    health_point int not null,
    attack_point int not null,
    defense_point int not null,
    magic_point int not null,
    exp int not null
);

create table monsters
(
    id SERIAL PRIMARY KEY,
    name TEXT not null,
    image bytea null,
    hp_min int not null,
    hp_max int not null,
    atk_min int not null,
    atk_max int not null,
    def_min int not null,
    def_max int not null,
    mag_min int not null,
    mag_max int not null,
    xp_drop int not null
);
