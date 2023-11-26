create table hero
(
    id            SERIAL PRIMARY KEY,
    name          TEXT not null,
    image         TEXT null,
    level         int  not null,
    health_point  int  not null,
    attack_point  int  not null,
    defense_point int  not null,
    magic_point   int  not null,
    exp           int  not null,
    speed         int  not null
);

create table monsters
(
    id        SERIAL PRIMARY KEY,
    name      TEXT not null,
    image     TEXT null,
    hp_min    int  not null,
    hp_max    int  not null,
    atk_min   int  not null,
    atk_max   int  not null,
    def_min   int  not null,
    def_max   int  not null,
    mag_min   int  not null,
    mag_max   int  not null,
    xp_drop   int  not null,
    speed_min int  not null,
    speed_max int  not null
);

create table opponent
(
    id            SERIAL PRIMARY KEY,
    type          TEXT not null,
    name          TEXT not null,
    image         TEXT null,
    health_point  int  not null,
    attack_point  int  not null,
    defense_point int  not null,
    magic_point   int  not null,
    speed         int  not null
);

create table story
(
    id               SERIAL PRIMARY KEY,
    descriptionID    int not null,
    text_description TEXT not null,
    localisation     TEXT not null,
    image            TEXT null,
    option1          TEXT not null,
    redirection1     int  not null,
    option2          TEXT not null,
    redirection2     int  not null,
    option3          TEXT not null,
    redirection3     int  not null,
    option4          TEXT not null,
    redirection4     int  not null,
    effects          TEXT null,
    monsterID        int null

);