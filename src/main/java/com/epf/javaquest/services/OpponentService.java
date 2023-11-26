package com.epf.javaquest.services;

import com.epf.javaquest.DAO.HeroDao;
import com.epf.javaquest.DAO.MonsterDao;
import com.epf.javaquest.DAO.OpponentDao;
import com.epf.javaquest.DTO.OpponentDto;
import com.epf.javaquest.DTO.OpponentMapper;
import com.epf.javaquest.models.Hero;
import com.epf.javaquest.models.Monster;
import com.epf.javaquest.models.Opponent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class OpponentService {
    private final OpponentDao opponentDao;
    private final MonsterDao monsterDao;
    private final HeroDao heroDao;

    public List<OpponentDto> startCombat(int idMonster) {
        opponentDao.deleteAll();
        Hero hero = heroDao.findById(0L).get(); // update 0 if multiple heroes available
        generateOpponentHero(hero);
        generateOpponentMonster(monsterDao.findById((long) idMonster).get());
        return OpponentMapper.toDtoList(opponentDao.findAll());
    }

    private void generateOpponentHero(Hero hero) {
        Opponent opponent = Opponent.builder()
                .origin_id(hero.getId())
                .type("Hero")
                .name(hero.getName())
                .healthPoint(hero.getHealthPoint())
                .attackPoint(hero.getAttackPoint())
                .defensePoint(hero.getDefensePoint())
                .magicPoint(hero.getMagicPoint())
                .speed(hero.getSpeed())
                .build();
        opponentDao.save(opponent);
    }

    private void generateOpponentMonster(Monster monster) {
        Opponent opponent = Opponent.builder()
                .origin_id(monster.getId())
                .type("Monster")
                .name(monster.getName())
                .healthPoint(statisticRandomizer(monster.getHpMin(), monster.getHpMax()))
                .attackPoint(statisticRandomizer(monster.getAtkMin(), monster.getAtkMax()))
                .defensePoint(statisticRandomizer(monster.getDefMin(), monster.getDefMax()))
                .magicPoint(statisticRandomizer(monster.getMagMin(), monster.getMagMax()))
                .speed(statisticRandomizer(monster.getSpeedMin(), monster.getSpeedMax()))
                .build();
        opponentDao.save(opponent);
    }

    private int statisticRandomizer(int stat_min, int stat_max) {
        Random random = new Random();
        return random.nextInt(stat_max - stat_min + 1) + stat_min;
    }

    public boolean checkStatus(String type) {
        int checkIndex;
        List<Opponent> opponents = opponentDao.findAll();
        checkIndex = opponents.get(0).getType().equals(type) ? 0 : 1;
        return opponents.get(checkIndex).isDead();
    }
}
