package com.epf.javaquest.services;

import com.epf.javaquest.DAO.MonsterDao;
import com.epf.javaquest.models.Monster;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class MonsterService {
    private final MonsterDao monsterDao;
    private final static int HEALTH_POINT_MULT = 8;
    private final static int ATTACK_POINT_MULT = 5;
    private final static int DEFENSE_POINT_MULT = 2;
    private final static int MAGIC_POINT_MULT = 2;
    private final static int LEVEL_UP_EXP_MULT = 100;
    private final static int LVL_INCR = 1;

    public Monster generateMonster(long id) { // randomiser l'id dans la génération du combat
        Monster monster = new Monster(monsterDao.findById(id).orElseThrow(RuntimeException::new));
        monster.setAttackPoint(statisticRandomizer(monster.getAtkMin(), monster.getAtkMax()));
        monster.setHealthPoint(statisticRandomizer(monster.getHpMin(), monster.getHpMax()));
        monster.setDefensePoint(statisticRandomizer(monster.getDefMin(), monster.getDefMax()));
        monster.setMagicPoint(statisticRandomizer(monster.getMagMin(), monster.getMagMax()));
        return monster;
    }

    public int statisticRandomizer(int stat_min, int stat_max) {
        Random random = new Random();
        return random.nextInt(stat_max - stat_min + 1) + stat_min;
    }

    public Monster getMonsterById(long id) {
        return monsterDao.findById(id).get();
    }

    public int getXpMonster(Monster monster) {
        return monster.getXpDrop();
    }

    public boolean isDead(Monster monster) {
        return monster.getHealthPoint() <= 0;
    }

//    public Monster updateMonsterStat(Monster monster, int hp_modifier, int atk_modifier, int def_modifier, int mag_modifier){
//        monster.setHealthPoint(monster.getHealthPoint() + hp_modifier);
//        monster.setAttackPoint(monster.getAttackPoint() + atk_modifier);
//        monster.setDefensePoint(monster.getDefensePoint() + def_modifier);
//        monster.setMagicPoint(monster.getMagicPoint() + mag_modifier);
//        return monster;
//    }

//    public int deleteMonster (Monster monster){
//        return 0;
//    }

    /*
    classe à creer ? :
    equipItem
    unequipItem
    getInventory
     */
}
