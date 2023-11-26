INSERT INTO hero (name, image, level, health_point, attack_point, defense_point, magic_point, exp, speed)
VALUES ('Hero1', NULL, 1, 8, 5, 2, 2, 0, 1);

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
VALUES (1, 'Bonjour, et bienvenue dans Javaquest. Vous vous appretez à vivre une aventure incroyable, où vos décisions seront importantes, et vos ennemis implacables. ' ||
           'Voyons un peu comment vous souhaitez jouez votre héros. Fasse à un adversaire, comment décidez vous de combattre >? ', '???', NULL, 'Prudemment. Je dois attendre le moment opportun pour frapper (+ 2 pv)', 2, 'Taper. Fort. ( +1 attaque)', 3, 'J utiliserais ma puissante armure pour échanger les attaques avec mon adversaire. Mais en ayant toujours un avantage ( +1 défense)', 4,
        'Rapide, efficace, frappant avant que mon adversaire ne puisse réagir (+2 vitesse)', 5, NULL),
       (2, 'Je vois. Mais vous ne devriez pas oubliez que la violence devrait être utilisé en dernier recours. Une rencontre pacifique sera bien plus rentable', '???', NULL, 'Ouais....On verra', 6, 'Je met les pieds ou je veux, et souvent dans les visages', 6,'Evidemment. Je me battrais en ultime recours' , 7,
        'Je ne possède aucun ennemi. Je ne me battrais que pour me proteger', 7, 'health_point:2'),
       (3, 'Je vois. Mais vous ne devriez pas oubliez que la violence devrait être utilisé en dernier recours. Une rencontre pacifique sera bien plus rentable', '??', NULL, 'Ouais....On verra', 6, 'Je met les pieds ou je veux, et souvent dans les visages', 6,'Evidemment. Je me battrais en ultime recours' , 7,
        'Je ne possède aucun ennemi. Je ne me battrais que pour me proteger', 7, 'attack_point:1'),
       (4, 'Je vois. Mais vous ne devriez pas oubliez que la violence devrait être utilisé en dernier recours. Une rencontre pacifique sera bien plus rentable', '???', NULL, 'Ouais....On verra', 6, 'Je met les pieds ou je veux, et souvent dans les visages', 6,'Evidemment. Je me battrais en ultime recours' , 7,
        'Je ne possède aucun ennemi. Je ne me battrais que pour me proteger', 7, 'defense_point:1'),
       (5, 'Je vois. Mais vous ne devriez pas oubliez que la violence devrait être utilisé en dernier recours. Une rencontre pacifique sera bien plus rentable', '???', NULL, 'Ouais....On verra', 6, 'Je met les pieds ou je veux, et souvent dans les visages', 6,'Evidemment. Je me battrais en ultime recours' , 7,
        'Je ne possède aucun ennemi. Je ne me battrais que pour me proteger', 7, 'speed :2'),
       (6, 'Espérons que tes pulsions de violences te permettront tout de même de survivre. Es tu prêt à partir en aventure ?', '???', NULL, 'Je suppose ?', 8, 'ABSOLUMENT !', 8,'Pas vraiment le choix en fait...' , 8,'Euh.... non ?', 8, NULL),
       (7, 'Un bel état d esprit ! Es tu prêt à partir en aventure ?', '???', NULL, 'Je suppose ?', 8, 'ABSOLUMENT !', 8,'Pas vraiment le choix en fait...' , 8, 'Euh.... non ?', 8, NULL),
       (8, 'Vous êtes, un aventurier de la guilde de Tantrop. Que ce soit à la recherche de gloire, de fortune, d''aventure ou de quelques relations hauts placés, vous avez réussis le difficile test de recrutement et êtes désormais un stagiaire aventurier, à la recherche d''un Contrat de Decouverte et d''Initiation, premier pas dans le vrai monde d''un aventurier. Assis au milieu de la taverne, vous attendez l''arrivé dIsabella, responsable de la guilde, qui va vous proposer une quete à réaliser... ' ||
           'Une naine aux cheveux roux, de longues couettes attaché par 2 gros anneaux de métal, les cheveux bouclés se présente devant vous. Son visage rond décorés d yeux semblables à 2 émeraudes et des lèvres fines, vous sourit tendrement,avant de transformer son visage en une grimace de dégout et vulgaire.' ||
           '"Bon sang, on accepte vraiment n''importe qui ici de nos jours. T''es censé être quoi en fait ?', 'Taverne de Tantrop', NULL, 'Isabella, je suppose ?', 9, 'Je te permet pas de me parler comme ça. Tu cherches les problèmes ?', 10,'Un stagiaire aventurier ne souhaitant que faire ses preuves !' , 11,
        'Je ne sais pas vraiment...Mon école m''impose un stage et j''ai juste été pris(e) ici...', 11, NULL),
       (9, '"Elle même. Cheffe en second de la guilde. Tu dois être le nouveau stagiaire ici je suppose ? Je vais te filer une petite quête, facile et rapide. Enfin, si t es pas trop stupide. Heh... ', 'Taverne de Tantrop', NULL, 'Stupide moi ? Je suis peut-être idiot mais pas non plus stupide hein..', 11, 'Je suis stagiaire ici oui. Merci de m offrir une chance', 11,'Tu oses m insulter ? Je vais t apprendre le respect moi... *Frapper Isabella*' , 10,
        'Jai hate de chatier mes ennemis...', 11, NULL),
       (10, 'Avant d avoir put réagir, une baffe capable de déboiter une machoire se pose "délicatement" sur votre joue. Un son lourd et sourd résonnant dans votre crane vous fait perdre la vue quelques secondes. Vous ne parvenez qu''à entendre que le son de votre sang montant par pulsion dans votre cerveau, votre corps luttant pour reprendre conscience. Votre vue revient petit à petit, et vous appercevez Isabella, tournant son poignet, le regard fier et hautain. Vous avez perdu 2 pv.' ||
            '" Tu disais le nouveau ?', 'Taverne de Tantrop', NULL, 'Pardon', 11, 'C''était...innatendu... ', 11,'Je rigolais, je te jure...;' , 11,
        'Tu verras quand je serais plus fort. J''aurais ma revanche...', 11, 'health_point : -2'),
       (11, '" Formidable ! Voici ta quête : Un groupe de gobelin au nord de la ville ont commencé à piller les caravanes marchandes et les villages alentours. Cependant, ils ne semblent pas être particulièrement violent. Ils pillent, blessent parfois, mais n''ont tué que ceux qui l''ont attaqué. Un stratagème inhabituel pour des gobelins. Va sur place, comprend ce qu''il se passe, et règle le problème. Des questions ? *Son poing se lève*  ', 'Taverne de Tantrop', NULL, 'Non...', 12, 'Non...', 12,'Non...' , 12,
        'En fait, oui...', 12, NULL),
       (12, '"Très bien ! Bon courage alors" Isabella tourne les talons, vous laissant seul à votre table. Que souhaitez vous faire ?', 'Taverne de Tantrop', NULL, 'Eh bah direction le nord alors...', 13, 'Il me faudrait de l''argent. Et de l''équipement. Direction le marché avant tout ', 14,'Il me faudrait de l argent, et vite. Direction l''arène !' , 15,
        'Personne ne m''en voudra si.... "j''emprunte" un peu d''équipement à la guilde n''est ce pas ? Direction les casiers privés des autres aventuriers...', 16, NULL),
       (13, ' Une odeur fétide agresse vos narines alors que vous arrivez aux écuries du nord de la ville. Devant vous, des chevaux sellés attachés semblent attendre leur cavaliers. A coté, un groupe de marchand préparent leur cargaisons dans un chariot tiré par deux mules. Enfin, la porte permettant de sortir de la ville est grande ouverte devant vous  ', 'Ecuries de Tantrop', NULL, 'Ce cheval sera à moi...', 17, 'Parlons au propriétaire. Jai besoin d un cheval', 18,'Bah ! J irais à pied' , 19,
        'Allons parler aux marchands.Isabella a bien dit que les gobelins les attaquaient non ?', 20, NULL),
       (14, 'Les étals colorés débordent d''une myriade de marchandises exotiques venues des confins du monde connu. Les odeurs enivrantes d''épices rares et de potions magiques flottent dans l''air, tandis que le brouhaha des négociations et les rires des marchands créent une symphonie animée par des musiciens créant une ambiance envoutante. Des tentes ornées de drapés chatoyants s''étirent sous le ciel, abritant des trésors éblouissants, des artefacts mystiques, des bijoux incrustés de gemmes aux propriétés mystiques, des étoffes aux couleurs éclatantes de tissus enchantés, des herbes rares aux vertus curatives et des marchandises inconnues...Des forgerons martèlent le métal avec une habileté ancestrale, créant des armes ornées de runes magiques' ||
            '.', 'Le marché', NULL, 'Magnifique. Essayons d''acheter de l''équipement !', 21, 'J''ai pas d''argent. Tant pis, voyons ce que je peux voler...' ,22,'Je suis un as de la négociation. J''arriverais bien à choper 2-3 trucs gratos' , 21,
        'Pas d''argent.... Retournons à la guilde', 12, NULL);