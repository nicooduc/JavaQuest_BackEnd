package com.epf.javaquest.services;

import com.epf.javaquest.DAO.HeroDao;
import com.epf.javaquest.models.Hero;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HeroService {
    private final HeroDao heroDao;

    //TODO classe probablement a supprimer si on affiche pas les stats du hero hors combat

    public Hero generateHero(String name, int level) {
        Hero hero = Hero.createHero(name, level);
        return heroDao.save(hero);
    }

    public Hero getHeroById(long id) {
        return heroDao.findById(id).get();
    }

    public Hero updateExp(Hero hero, int exp_gain) {
        hero.updateExp(exp_gain);
        heroDao.save(hero);
        return hero;
    }

    public Hero updateHeroLevel(Hero hero) {
        hero.levelUp();
        System.out.println("LVL UP !!!!");
        return hero;
    }

    public Hero updateHeroStat(Hero hero, int hp_modifier, int atk_modifier, int def_modifier, int mag_modifier, int speed_modifier) {
        hero.updateStats(hp_modifier, atk_modifier, def_modifier, mag_modifier, speed_modifier);
        heroDao.save(hero);
        return hero;
    }

    public int deleteHero(Hero hero) {
        heroDao.delete(hero);
        return 0;
    }

    /*
    classe à creer ? :
    equipItem
    unequipItem
    getInventory
     */
}
