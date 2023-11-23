package com.epf.javaquest.services;

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
    private final OpponentMapper opponentMapper;

    // TODO ajouter les saves en base

    public Opponent generateTempHero(Hero hero) {
        Opponent opponent = Opponent.builder()
                .type("hero")
                .name(hero.getName())
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
                .name(monster.getName())
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


    // TODO - Exemple des requetes possibles - supprimer la majorité
    public List<Opponent> findAll() {
        return opponentDao.findAll();
    }

    public Opponent getById(Long id) {
        return opponentDao.findById(id).get();
    }

    public void deleteById(Long id) {
        opponentDao.deleteById(id);
    }

    public void addOpponent(OpponentDto opponentDto) {
        Opponent opponent = opponentMapper.fromDto(opponentDto);
        opponentDao.save(opponent);
    }

    public void updateOpponent(OpponentDto opponentDto, Long id) {
        Opponent opponent = opponentDao.findById(id).get();
        opponent.setType("opponent");
        opponent.setHealthPoint(opponentDto.getHealthPoint());
        opponent.setAttackPoint(opponentDto.getAttackPoint());
        opponent.setDefensePoint(opponentDto.getDefensePoint());
        opponent.setMagicPoint(opponentDto.getMagicPoint());
        opponent.setSpeed(opponentDto.getSpeed());
        opponentDao.save(opponent);
    }
}
