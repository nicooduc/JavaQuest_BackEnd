package com.epf.javaquest.services;

import com.epf.javaquest.models.Hero;
import com.epf.javaquest.models.Monster;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class FightService {

    public void turnFunction(Hero hero, Monster monster) {
        int playerChoice = playerChoice();
        int monsterChoice = monsterChoice();
        int speedHero = hero.getSpeed();
        int speedMonster = monster.getSpeedPoint();


        if (playerChoice == 2) {
            hero.choiceDefense();
        }
        if (monsterChoice == 2) {
            System.out.println("Il se prépare à encaisser !");
            monster.choiceDefense();
        }

        if (speedMonster <= speedHero) {
            actionPlayer(hero, monster, playerChoice);
            actionMonster(monster, hero, monsterChoice);
        } else {
            actionMonster(monster, hero, monsterChoice);
            actionPlayer(hero, monster, playerChoice);
        }
        endTurn(hero, monster, playerChoice, monsterChoice);

    }

    private void endTurn(Hero hero, Monster monster, int playerChoice, int monsterChoice) {
        if (playerChoice == 2) {
            hero.resetDefense();
        }
        if (monsterChoice == 2) {
            monster.resetDefense();
        }

    }

    public int playerChoice() {
        int choix;

        // TODO connexion frontend
        Scanner scanner = new Scanner(System.in);

        System.out.print("Veuillez entrer un chiffre : ");
        System.out.println("1. Atk");
        System.out.println("2. Def");
        System.out.println("3. Mag");
        System.out.print("Entrez votre choix (1-3) : ");

        choix = scanner.nextInt();

        scanner.close();
        return choix;
    }

    public int monsterChoice() {
        Random random = new Random();

        return random.nextInt(3);
    }

    public boolean actionPlayer(Hero hero, Monster monster, int playerChoice) {
        switch (playerChoice) {
            case 1:
                System.out.println("Atk");
                attackHero(hero, monster);
                break;
            case 3:
                System.out.println("Mag");
                hero.regenHealthMag();
                break;

        }

        return true;
    }


    public boolean actionMonster(Monster monster, Hero hero, int monsterChoice) {
        switch (monsterChoice) {
            case 0:
                System.out.println("afk");
                break;
            case 1:
                System.out.println("Atk monster");
                attackMonster(hero, monster);
                break;
            case 3:
                System.out.println("MAGIIIIE (du monstre)");
                monster.regenHealthMag();
        }
        return true;
    }

    public boolean attackHero(Hero hero, Monster monster) {
        int atkHero = hero.getAttackPoint();
        int defMonster = monster.getDefensePoint();
        int dmgDone = atkHero - defMonster;

        if (dmgDone > 0) {
            monster.updateHealth(dmgDone);
        } else {
            System.out.println("Monster Defense Too Big !");
        }

        return true;
    }

    public boolean attackMonster(Hero hero, Monster monster) {
        int atkMonster = monster.getAttackPoint();
        int defHero = hero.getDefensePoint();
        int dmgDone = atkMonster - defHero;

        if (dmgDone > 0) {
            hero.updateHealth(dmgDone);
        } else {
            System.out.println("Hero Defense Too Big !");
        }

        return true;
    }
}
