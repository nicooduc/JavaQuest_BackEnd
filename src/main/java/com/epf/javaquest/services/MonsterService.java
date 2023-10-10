package com.epf.javaquest.services;

import com.epf.javaquest.DAO.MonsterDao;
import com.epf.javaquest.models.Hero;
import com.epf.javaquest.models.Monster;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class MonsterService {
    private final MonsterDao monsterDao;

    public Monster generateMonster(long id) { // randomiser l'id dans la génération du combat
        Monster monsterBase = new Monster(monsterDao.findById(id).orElseThrow(RuntimeException::new));
        Monster monster = Monster.builder()
                .name(monsterBase.getName())
                .healthPoint(statisticRandomizer(monsterBase.getHpMin(), monsterBase.getHpMax()))
                .attackPoint(statisticRandomizer(monsterBase.getAtkMin(), monsterBase.getAtkMax()))
                .defensePoint(statisticRandomizer(monsterBase.getDefMin(), monsterBase.getDefMax()))
                .magicPoint(statisticRandomizer(monsterBase.getMagMin(), monsterBase.getMagMax()))
                .xpDrop(monsterBase.getXpDrop())
                .build();
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

    public Monster updateHealth(Monster monster, int hp_modifier) {
        monster.setHealthPoint(monster.getHealthPoint() + hp_modifier);
        return monster;
    }

    public Monster updateAttack(Monster monster, int atk_modifier){
        monster.setAttackPoint(monster.getAttackPoint() + atk_modifier);
        return monster;
    }

    public Monster updateDefense(Monster monster, int def_modifier){
        monster.setDefensePoint(monster.getDefensePoint() + def_modifier);
        return monster;
    }

    public Monster updateMagic(Monster monster,int mag_modifier){
        monster.setMagicPoint(monster.getMagicPoint() + mag_modifier);
        return monster;
    }

    public int deleteMonster (Monster monster){
        monster = null; // Permet bien de le détruire ?
        return 0;
    }

    /*
    classe à creer ? :
    equipItem
    unequipItem
    getInventory
     */
}
