package com.epf.javaquest;

import com.epf.javaquest.models.Hero;
import com.epf.javaquest.models.Monster;
import com.epf.javaquest.services.FightService;
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
    private final FightService fightService;

    @Override
    public void run(String... args) {
//        Hero hero = heroService.generateHero("Héros 1", 1);
//
//        // Affichez les statistiques du héros
//        System.out.println("Héros : " + hero.getName());
//        System.out.println("Niveau : " + hero.getLevel());
//        System.out.println("Points de vie : " + hero.getHealthPoint());
//        System.out.println("Points d'attaque : " + hero.getAttackPoint());
//        System.out.println("Points de défense : " + hero.getDefensePoint());
//        System.out.println("Points de magie : " + hero.getMagicPoint());
//        System.out.println();
//
//        // Récupérer
//        Monster monster = monsterService.getMonsterById(1L);
//
//        heroService.updateExp(hero, 108);
//
//        System.out.println("__________________________");
//
//        fightService.fightFunction(hero, monster);
//        System.out.println("Fin de combat");
//        System.out.println(hero);
//        System.out.println(monster);
//        fightService.fightFunction(hero, monster);
//        System.out.println("Fin de combat");
//        System.out.println(hero);
    }
}
