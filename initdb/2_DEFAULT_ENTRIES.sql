INSERT INTO hero (name, image, level, health_point, attack_point, defense_point, magic_point, exp, speed)
VALUES ('Hero1', NULL, 1, 80, 70, 40, 30, 0, 4);

INSERT INTO monsters (name, image, hp_min, hp_max, atk_min, atk_max, def_min, def_max, mag_min, mag_max, xp_drop,
                      speed_min, speed_max)
VALUES ('Monster1', NULL, 10, 30, 4, 7, 1, 3, 1, 2, 205, 2, 5),
       ('Monster2', NULL, 20, 40, 2, 3, 2, 4, 2, 3, 102, 1, 3),
       ('Monster3', NULL, 1, 2, 2, 4, 3, 5, 1, 2, 45, 1, 8);

INSERT INTO opponent (type, name, image, health_point, attack_point, defense_point, magic_point, speed)
VALUES ('Opponent1', 'Kop', NULL, 80, 70, 40, 30, 4),
       ('Opponent2', 'Gob', NULL, 8, 7, 4, 3, 40);

INSERT INTO story (descriptionID, text_description, localisation, image, option1, redirection1, option2, redirection2,
                   option3, redirection3, option4, redirection4, effects)
VALUES (1, 'Description 1', 'taverne de tantrop1', NULL, 'Option 1-1', 2, 'Option 1-2', 3, 'Option 1-3', 4,
        'Option 1-4', 5, NULL),
       (2, 'Description 2', 'taverne de tantrop2', NULL, 'Option 2-1', 6, 'Option 2-2', 7, 'Option 2-3', 8,
        'Option 2-4', 9, 'health_point:2;attack_point:2;defense_point:2;magic_point:2;exp:+2;speed:2'),
       (3, 'Description 3', 'taverne de tantrop3', NULL, 'Option 3-1', 10, 'Option 3-2', 11, 'Option 3-3', 12,
        'Option 3-4', 13, NULL),
       (4, 'Description 4', 'taverne de tantrop4', NULL, 'Option 4-1', 14, 'Option 4-2', 15, 'Option 4-3', 16,
        'Option 4-4', 17, 'health_point:-2;attack_point:-2'),
       (5, 'Description 5', 'taverne de tantrop5', NULL, 'Option 5-1', 18, 'Option 5-2', 19, 'Option 5-3', 20,
        'Option 5-4', 21, NULL);