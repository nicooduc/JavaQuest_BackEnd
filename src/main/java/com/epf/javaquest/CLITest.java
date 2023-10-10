package com.epf.javaquest;

import com.epf.javaquest.models.Hero;
import com.epf.javaquest.models.Monster;
import com.epf.javaquest.services.HeroService;
import com.epf.javaquest.services.MonsterService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CLITest implements CommandLineRunner {
    private final HeroService heroService;
    private final MonsterService monsterService;
    @Override
    public void run(String... args) {
        Hero hero = heroService.generateHero("Héros 1", 10);

        // Affichez les statistiques du héros
        System.out.println("Héros : " + hero.getName());
        System.out.println("Niveau : " + hero.getLevel());
        System.out.println("Points de vie : " + hero.getHealthPoint());
        System.out.println("Points d'attaque : " + hero.getAttackPoint());
        System.out.println("Points de défense : " + hero.getDefensePoint());
        System.out.println("Points de magie : " + hero.getMagicPoint());
        System.out.println();

        // Générez un monstre aléatoire
        Monster randomMonster = monsterService.generateMonster(1L);

        // Affichez les statistiques du monstre aléatoire
        System.out.println("Monstre : " + randomMonster.getName());
        System.out.println("Points de vie : " + randomMonster.getHealthPoint());
        System.out.println("Points d'attaque : " + randomMonster.getAttackPoint());
        System.out.println("Points de défense : " + randomMonster.getDefensePoint());
        System.out.println("Points de magie : " + randomMonster.getMagicPoint());

    }
}
