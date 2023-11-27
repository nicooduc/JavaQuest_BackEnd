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

    /**
     * Démarre un combat en supprimant tous les opposants existants, génère un héros et un monstre,
     * puis retourne la liste des opposants sous forme de DTO.
     *
     * @param idMonster ID du monstre à affronter
     * @return Liste des opposants en tant que DTO
     */
    public List<OpponentDto> startCombat(int idMonster) {
        opponentDao.deleteAll();
        Hero hero = heroDao.findById(1L).get(); // Mettre à jour avec 0 s'il y a plusieurs héros disponibles
        generateOpponentHero(hero);
        generateOpponentMonster(monsterDao.findById((long) idMonster).get());

        return OpponentMapper.toDtoList(opponentDao.findAll());
    }

    /**
     * Génère un opposant de type héros à partir des caractéristiques d'un héros donné.
     *
     * @param hero Héros à partir duquel générer l'opposant
     */
    private void generateOpponentHero(Hero hero) {
        Opponent opponent = Opponent.builder().origin_id(hero.getId()).type("Hero").name(hero.getName()).healthPoint(hero.getHealthPoint()).attackPoint(hero.getAttackPoint()).defensePoint(hero.getDefensePoint()).magicPoint(hero.getMagicPoint()).speed(hero.getSpeed()).build();
        opponentDao.save(opponent);
    }

    /**
     * Génère un opposant de type monstre à partir des caractéristiques d'un monstre donné.
     *
     * @param monster Monstre à partir duquel générer l'opposant
     */
    private void generateOpponentMonster(Monster monster) {
        Opponent opponent = Opponent.builder().origin_id(monster.getId()).type("Monster").name(monster.getName()).healthPoint(statisticRandomizer(monster.getHpMin(), monster.getHpMax())).attackPoint(statisticRandomizer(monster.getAtkMin(), monster.getAtkMax())).defensePoint(statisticRandomizer(monster.getDefMin(), monster.getDefMax())).magicPoint(statisticRandomizer(monster.getMagMin(), monster.getMagMax())).speed(statisticRandomizer(monster.getSpeedMin(), monster.getSpeedMax())).build();
        opponentDao.save(opponent);
    }

    /**
     * Génère un nombre aléatoire compris entre les valeurs minimales et maximales spécifiées.
     *
     * @param stat_min Valeur minimale de la statistique
     * @param stat_max Valeur maximale de la statistique
     * @return Nombre aléatoire généré
     */
    private int statisticRandomizer(int stat_min, int stat_max) {
        Random random = new Random();
        return random.nextInt(stat_max - stat_min + 1) + stat_min;
    }

    /**
     * Vérifie l'état de santé d'un opposant en fonction de son type.
     *
     * @param type Type de l'opposant (Hero ou Monster)
     * @return true si l'opposant est mort, false sinon
     */
    public boolean checkStatus(String type) {
        int checkIndex;
        List<Opponent> opponents = opponentDao.findAll();
        checkIndex = opponents.get(0).getType().equals(type) ? 0 : 1;
        return opponents.get(checkIndex).isDead();
    }
}
