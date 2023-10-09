create table statistics
(
    id SERIAL PRIMARY KEY,
    health_point int null,
    attack_point int null,
    defense_point int null,
    magic_point int null
    --charisma int null
);

create table hero
(
    id SERIAL PRIMARY KEY,
    name TEXT not null,
    --gold int null,
    image bytea null,
    id_statistics int null
);

create table monsters
(
    id SERIAL PRIMARY KEY,
    name TEXT not null,
    --friend int null,
    --drop_rate int null,
    image bytea null,
    hp_mult_min int null,
    hp_mult_max int null,
    atk_mult_min int null,
    atk_mult_max int null,
    def_mult_min int null,
    def_mult_max int null,
    mag_mult_min int null,
    mag_mult_max int null,
    id_statistics int null
);
