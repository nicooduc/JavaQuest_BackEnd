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
                .speedPoint(statisticRandomizer(monsterBase.getSpeedMin(), monsterBase.getSpeedMax()))
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

    public boolean isDead(Monster monster) {
        return monster.getHealthPoint() <= 0;
    }

    /*
    classe à creer ? :
    equipItem
    unequipItem
    getInventory
     */
}
