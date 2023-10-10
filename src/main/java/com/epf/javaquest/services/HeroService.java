package com.epf.javaquest.services;

import com.epf.javaquest.DAO.HeroDao;
import com.epf.javaquest.models.Hero;
import com.epf.javaquest.models.Monster;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HeroService {
    private final HeroDao heroDao;
    private final static int HEALTH_POINT_MULT = 8;
    private final static int ATTACK_POINT_MULT = 5;
    private final static int DEFENSE_POINT_MULT = 2;
    private final static int MAGIC_POINT_MULT = 2;
    private final static int LEVEL_UP_EXP_MULT = 100;
    private final static int LVL_INCR = 1;

    public Hero generateHero(String name, int level){
        Hero hero = Hero.builder()
                .name(name)
                .level(level)
                .healthPoint(HEALTH_POINT_MULT *level)
                .attackPoint(ATTACK_POINT_MULT *level)
                .defensePoint(DEFENSE_POINT_MULT *level)
                .magicPoint(MAGIC_POINT_MULT *level)
                .exp(0)
                .build();
        return heroDao.save(hero);
    }

    public Hero getHeroById(long id) {
        return heroDao.findById(id).get();
    }

    public Hero updateExp (Hero hero, int exp_gain){
        int current_exp = hero.getExp() + exp_gain;
        int exp_to_levelup = hero.getLevel() * LEVEL_UP_EXP_MULT;
        if (current_exp >= exp_to_levelup)
        {
            hero.setExp(current_exp - exp_to_levelup);
            updateHeroLevel(hero);
        } else {
            hero.setExp(current_exp);
            heroDao.save(hero);
        }
        return hero;
    }

    public Hero updateHeroLevel(Hero hero){
        hero.setLevel(hero.getLevel() + LVL_INCR);
        hero = updateHeroStat(hero, HEALTH_POINT_MULT, ATTACK_POINT_MULT, DEFENSE_POINT_MULT, MAGIC_POINT_MULT);
        return hero;
    }

    public Hero updateHeroStat(Hero hero, int hp_modifier, int atk_modifier, int def_modifier, int mag_modifier){
        hero.setHealthPoint(hero.getHealthPoint() + hp_modifier);
        hero.setAttackPoint(hero.getAttackPoint() + atk_modifier);
        hero.setDefensePoint(hero.getDefensePoint() + def_modifier);
        hero.setMagicPoint(hero.getMagicPoint() + mag_modifier);
        heroDao.save(hero);
        return hero;
    }

    public int deleteHero (Hero hero){
        heroDao.delete(hero);
        return 0;
    }

    public boolean isDead(Hero hero) {
        return hero.getHealthPoint() <= 0;
    }

    /*
    classe à creer ? :
    equipItem
    unequipItem
    getInventory
     */
}
