package com.epf.javaquest.services;

import com.epf.javaquest.DAO.OpponentDao;
import com.epf.javaquest.models.Hero;
import com.epf.javaquest.models.Monster;
import com.epf.javaquest.models.Opponent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@RequiredArgsConstructor
public class OpponentService {
    private final OpponentDao opponentDao;

    public Opponent generateTempHero(Hero hero) {
        Opponent opponent = Opponent.builder()
                .type("hero")
                .healthPoint(hero.getHealthPoint())
                .attackPoint(hero.getAttackPoint())
                .defensePoint(hero.getDefensePoint())
                .magicPoint(hero.getMagicPoint())
                .speed(hero.getSpeed())
                .build();
        return opponent;
    }

    public Opponent generateTempMonster(Monster monster) {
        Opponent opponent = Opponent.builder()
                .type("monster")
                .healthPoint(statisticRandomizer(monster.getHpMin(), monster.getHpMax()))
                .attackPoint(statisticRandomizer(monster.getAtkMin(), monster.getAtkMax()))
                .defensePoint(statisticRandomizer(monster.getDefMin(), monster.getDefMax()))
                .magicPoint(statisticRandomizer(monster.getMagMin(), monster.getMagMax()))
                .speed(statisticRandomizer(monster.getSpeedMin(), monster.getSpeedMax()))
                .build();
        return opponent;
    }

    public int statisticRandomizer(int stat_min, int stat_max) {
        Random random = new Random();
        return random.nextInt(stat_max - stat_min + 1) + stat_min;
    }

}
