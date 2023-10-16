package com.epf.javaquest.services;

import com.epf.javaquest.models.Hero;
import com.epf.javaquest.models.Monster;
import com.epf.javaquest.models.Opponent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class FightService {
    private final HeroService heroService;
    private final OpponentService opponentService;

    public boolean fightFunction(Hero hero, Monster monster) {
        Opponent tempHero = opponentService.generateTempHero(hero);
        Opponent tempMonster = opponentService.generateTempMonster(monster);
        System.out.println("hero : " + tempHero);
        System.out.println("monster : " + tempMonster);
        do {
            turnFunction(tempHero, tempMonster);
            System.out.println("hero : " + tempHero);
            System.out.println("monster : " + tempMonster);
        } while (!tempMonster.isDead() && !tempHero.isDead());

        if (tempMonster.isDead()) {
            System.out.println("VICTORYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY!");
            heroService.updateExp(hero, monster.getXpDrop());
        } else {
            System.out.println("LOOOOOOOOOOOOOOOOSSSSSSSSSSSEEEEEEERRRRRRRRRRRR");
        }

        return true;
    }

    public boolean turnFunction(Opponent tempHero, Opponent tempMonster) {
        int playerChoice = playerChoice();
        int monsterChoice = monsterChoice();
        int speedHero = tempHero.getSpeed();
        int speedMonster = tempMonster.getSpeed();


        if (playerChoice == 2) {
            tempHero.choiceDefense();
        }
        if (monsterChoice == 2) {
            System.out.println("Il se prépare à encaisser !");
            tempMonster.choiceDefense();
        }

        if (speedMonster <= speedHero) {
            actionPlayer(tempHero, tempMonster, playerChoice);
            actionMonster(tempMonster, tempHero, monsterChoice);
        } else {
            actionMonster(tempMonster, tempHero, monsterChoice);
            actionPlayer(tempHero, tempMonster, playerChoice);
        }
        endTurn(tempHero, tempMonster, playerChoice, monsterChoice);

        return true;
    }

    private boolean endTurn(Opponent tempHero, Opponent tempMonster, int playerChoice, int monsterChoice) {
        if (playerChoice == 2) {
            tempHero.resetDefense();
        }
        if (monsterChoice == 2) {
            tempMonster.resetDefense();
        }
        return true;

    }

    public int playerChoice() {
        int choix;

        // TODO connexion frontend
        Scanner scanner = new Scanner(System.in);

        System.out.println("Veuillez entrer un chiffre : ");
        System.out.println("1. Atk");
        System.out.println("2. Def");
        System.out.println("3. Mag");
        System.out.println("Entrez votre choix (1-3) : ");

        choix = scanner.nextInt();

//        scanner.close();
        return choix;
    }

    public int monsterChoice() {
        Random random = new Random();

        return random.nextInt(3);
    }

    public boolean actionPlayer(Opponent tempHero, Opponent tempMonster, int playerChoice) {
        switch (playerChoice) {
            case 1:
                System.out.println("Atk");
                attack(tempHero, tempMonster);
                break;
            case 3:
                System.out.println("Mag");
                tempHero.regenHealthMag();
                break;

        }

        return true;
    }


    public boolean actionMonster(Opponent tempMonster, Opponent tempHero, int monsterChoice) {
        switch (monsterChoice) {
            case 0:
                System.out.println("afk");
                break;
            case 1:
                System.out.println("Atk monster");
                attack(tempMonster, tempHero);
                break;
            case 3:
                System.out.println("MAGIIIIE (du monstre)");
                tempMonster.regenHealthMag();
        }
        return true;
    }

    public boolean attack(Opponent attacker, Opponent defender) {
        int atk = attacker.getAttackPoint();
        int def = defender.getDefensePoint();
        int dmgDone = atk - def;

        if (dmgDone > 0) {
            defender.updateHealth(-dmgDone);
        } else {
            System.out.println(defender.getType() + "Defense Too Big !");
        }

        return true;
    }
}
