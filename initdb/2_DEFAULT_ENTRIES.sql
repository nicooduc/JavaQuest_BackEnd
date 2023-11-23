INSERT INTO hero (name, image,level, health_point, attack_point, defense_point, magic_point, exp, speed)
    VALUES ('Hero1', NULL, 1, 80, 70, 40, 30, 0,4);

INSERT INTO monsters (name, image, hp_min, hp_max, atk_min, atk_max, def_min, def_max, mag_min, mag_max, xp_drop, speed_min,speed_max)
    VALUES ('Monster1', NULL, 10, 30, 4, 7, 1, 3, 1, 2, 205, 2, 5);
INSERT INTO monsters (name, image, hp_min, hp_max, atk_min, atk_max, def_min, def_max, mag_min, mag_max, xp_drop, speed_min,speed_max)
    VALUES ('Monster2', NULL, 20, 40, 2, 3, 2, 4, 2, 3, 102, 1, 3);
INSERT INTO monsters (name, image, hp_min, hp_max, atk_min, atk_max, def_min, def_max, mag_min, mag_max, xp_drop, speed_min,speed_max)
    VALUES ('Monster3', NULL, 1, 2, 2, 4, 3, 5, 1, 2, 45, 1, 8);

INSERT INTO opponent (type,name , image, health_point, attack_point, defense_point, magic_point, speed)
VALUES ('Opponent1','Kop', NULL, 80, 70, 40, 30,4);
INSERT INTO opponent (type, name, image, health_point, attack_point, defense_point, magic_point, speed)
VALUES ('Opponent2','Gob', NULL, 8, 7, 4, 3,40);