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

        if (playerChoice == 2) {

        }
        if (monsterChoice == 2) {

        }

        switch (playerChoice) {
            case 1:
                System.out.println("Atk");
                //fonction1();
                break;
            case 2:
                System.out.println("Def");
                //fonction2();
                break;
            case 3:
                System.out.println("Mag");
                //fonction3();
                break;
            case 4:
                System.out.println("Quitter le jeu.");
                break;


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
        return random.nextInt(2);
    }


}
