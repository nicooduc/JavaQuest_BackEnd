package com.epf.javaquest.services;

import com.epf.javaquest.DAO.OpponentDao;
import com.epf.javaquest.models.Opponent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class FightService {
    private final HeroService heroService;
    private final OpponentDao opponentDao;

    public List<Opponent> turn(String actionHero) {
        int heroIndex;
        int monsterIndex;
        String actionMonster = actionMonster();
        //TODO récupérer les hero et monstres de la base
        List<Opponent> opponents = opponentDao.findAll();
        if (opponents.get(0).getType().equals("hero")) {
            heroIndex = 0;
            monsterIndex = 1;
        } else {
            heroIndex = 1;
            monsterIndex = 0;
        }
        Opponent tempHero = opponents.get(heroIndex);
        Opponent tempMonster = opponents.get(monsterIndex);
        int speedHero = opponents.get(heroIndex).getSpeed();
        int speedMonster = opponents.get(monsterIndex).getSpeed();


        if (Objects.equals(actionHero, "defend")) {
            tempHero.choiceDefense();
        }
        if (Objects.equals(actionMonster, "defend")) {
            System.out.println("Il se prépare à encaisser !");
            tempMonster.choiceDefense();
        }

        if (speedMonster <= speedHero) {
            actionPlayer(tempHero, tempMonster, actionHero);
            actionMonster(tempMonster, tempHero, actionMonster);
        } else {
            actionMonster(tempMonster, tempHero, actionMonster);
            actionPlayer(tempHero, tempMonster, actionHero);
        }
        endTurn(tempHero, tempMonster, actionHero, actionMonster);
        opponentDao.save(tempHero);
        opponentDao.save(tempMonster);
        return opponentDao.findAll();
    }

    private String actionMonster() {
        Random random = new Random();
        return switch (random.nextInt(3)) {
            case 0 -> "defend";
            case 1 -> "attack";
            case 2 -> "castMagic";
            default -> "afk";
        };
    }

    private void actionPlayer(Opponent tempHero, Opponent tempMonster, String playerChoice) {
        switch (playerChoice) {
            case "attack":
                System.out.println("Atk");
                attack(tempHero, tempMonster);
                break;
            case "castMagic":
                System.out.println("Mag");
                tempHero.regenHealthMag();
                break;
        }
    }


    private void actionMonster(Opponent tempMonster, Opponent tempHero, String monsterChoice) {
        switch (monsterChoice) {
            case "afk":
                System.out.println("afk");
                break;
            case "attack":
                System.out.println("Atk monster");
                attack(tempMonster, tempHero);
                break;
            case "castMagic":
                System.out.println("MAGIIIIE (du monstre)");
                tempMonster.regenHealthMag();
        }
    }

    private void endTurn(Opponent tempHero, Opponent tempMonster, String playerChoice, String monsterChoice) {
        if (Objects.equals(playerChoice, "defend")) {
            tempHero.resetDefense();
        }
        if (Objects.equals(monsterChoice, "defend")) {
            tempMonster.resetDefense();
        }
    }

    private void attack(Opponent attacker, Opponent defender) {
        int atk = attacker.getAttackPoint();
        int def = defender.getDefensePoint();
        int dmgDone = atk - def;

        if (dmgDone > 0) {
            defender.updateHealth(-dmgDone);
        } else {
            System.out.println(defender.getType() + "Defense Too Big !");
        }
    }


    // TODO toutes les fonctions en dessous étaient pour le fonctionnement backend

//        public boolean fightFunction (Hero hero, Monster monster){
//            Opponent tempHero = opponentService.generateTempHero(hero);
//            Opponent tempMonster = opponentService.generateTempMonster(monster);
//            System.out.println("hero : " + tempHero);
//            System.out.println("monster : " + tempMonster);
//            do {
//                turnFunction(tempHero, tempMonster);
//                System.out.println("hero : " + tempHero);
//                System.out.println("monster : " + tempMonster);
//            } while (!tempMonster.isDead() && !tempHero.isDead());
//
//            if (tempMonster.isDead()) {
//                System.out.println("VICTORYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY!");
//                heroService.updateExp(hero, monster.getXpDrop());
//            } else {
//                System.out.println("LOOOOOOOOOOOOOOOOSSSSSSSSSSSEEEEEEERRRRRRRRRRRR");
//            }
//
//            return true;
//        }

//        public boolean turnFunction (Opponent tempHero, Opponent tempMonster){
//            int playerChoice = playerChoice();
//            int monsterChoice = actionMonster();
//            int speedHero = tempHero.getSpeed();
//            int speedMonster = tempMonster.getSpeed();
//
//
//            if (playerChoice == 2) {
//                tempHero.choiceDefense();
//            }
//            if (monsterChoice == 2) {
//                System.out.println("Il se prépare à encaisser !");
//                tempMonster.choiceDefense();
//            }
//
//            if (speedMonster <= speedHero) {
//                actionPlayer(tempHero, tempMonster, playerChoice);
//                actionMonster(tempMonster, tempHero, monsterChoice);
//            } else {
//                actionMonster(tempMonster, tempHero, monsterChoice);
//                actionPlayer(tempHero, tempMonster, playerChoice);
//            }
//            endTurn(tempHero, tempMonster, playerChoice, monsterChoice);
//
//            return true;
//        }


//        public int playerChoice () {
//            int choix;
//
//            // TODO connexion frontend
//            Scanner scanner = new Scanner(System.in);
//
//            System.out.println("Veuillez entrer un chiffre : ");
//            System.out.println("1. Atk");
//            System.out.println("2. Def");
//            System.out.println("3. Mag");
//            System.out.println("Entrez votre choix (1-3) : ");
//
//            choix = scanner.nextInt();
//
////        scanner.close();
//            return choix;
//        }


}
