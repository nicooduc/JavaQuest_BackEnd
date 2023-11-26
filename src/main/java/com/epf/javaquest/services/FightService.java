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
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class FightService {
    private final OpponentDao opponentDao;
    private final MonsterDao monsterDao;
    private final HeroDao heroDao;

    public List<OpponentDto> turn(String actionHero) {
        System.out.println("Choix du hero : " + actionHero);
        int heroIndex;
        int monsterIndex;
        String actionMonster = actionMonster();
        System.out.println("Choix du monstre : " + actionMonster);
        List<Opponent> opponents = opponentDao.findAll();
        heroIndex = opponents.get(0).getType().equals("Hero") ? 0 : 1;
        monsterIndex = 1 - heroIndex;
        Opponent tempHero = opponents.get(heroIndex);
        Opponent tempMonster = opponents.get(monsterIndex);
        System.out.println("tempHero.type = " + tempHero.getType());
        System.out.println("tempMonster.type = " + tempMonster.getType());
        int speedHero = opponents.get(heroIndex).getSpeed();
        int speedMonster = opponents.get(monsterIndex).getSpeed();


        if (Objects.equals(actionHero, "defend")) {
            System.out.println("Le hero se prepare a encaisser");
            tempHero.choiceDefense();
        }
        if (Objects.equals(actionMonster, "defend")) {
            System.out.println("Le monstre se prépare a encaisser");
            tempMonster.choiceDefense();
        }

        if (speedMonster <= speedHero) {
            System.out.println("Le hero a l'initiative");
            actionPlayer(tempHero, tempMonster, actionHero);
            actionMonster(tempMonster, tempHero, actionMonster);
        } else {
            System.out.println("Le monstre a l'initiative");
            actionMonster(tempMonster, tempHero, actionMonster);
            actionPlayer(tempHero, tempMonster, actionHero);
        }
        endTurn(tempHero, tempMonster, actionHero, actionMonster);
        opponentDao.save(tempHero);
        opponentDao.save(tempMonster);
        return OpponentMapper.toDtoList(opponentDao.findAll());
    }

    public Integer endFight(boolean success) {
        if (success) {
            int heroIndex;
            int monsterIndex;
            Hero hero;
            List<Opponent> opponents = opponentDao.findAll();
            heroIndex = opponents.get(0).getType().equals("Hero") ? 0 : 1;
            monsterIndex = 1 - heroIndex;

            Optional<Hero> heroOptional = heroDao.findById(opponents.get(heroIndex).getOrigin_id());
            Optional<Monster> monster = monsterDao.findById(opponents.get(monsterIndex).getOrigin_id());
            int expGain = monster.map(Monster::getXpDrop).orElse(0);
            if (heroOptional.isPresent()) {
                hero = heroOptional.get();
                expGain = hero.updateExp(expGain);
                heroDao.save(hero);
            }
            opponentDao.deleteAll();
            return expGain;
        } else {
            heroDao.deleteById(0L); // update 0 if multiple heroes available
            Hero.createHero("Cop", 1); //TODO hero par défault recréé, proposer l'option de création de hero au joueur
            opponentDao.deleteAll();
            return 0;
        }

    }

    private String actionMonster() {
        Random random = new Random();
        return switch (random.nextInt(4)) {
            case 0 -> "defend";
            case 1 -> "attack";
            case 2 -> "castMagic";
            default -> "afk";
        };
    }

    private void actionPlayer(Opponent tempHero, Opponent tempMonster, String playerChoice) {
        System.out.println("Le joueur a choisi l'action " + playerChoice);
        System.out.println("Le type du joueur est : " + tempHero.getType());
        switch (playerChoice) {
            case "attack":
                System.out.println("Le hero attaque");
                attack(tempHero, tempMonster);
                break;
            case "castMagic":
                System.out.println("Le hero se soigne");
                tempHero.regenHealthMag();
                break;
        }
    }


    private void actionMonster(Opponent tempMonster, Opponent tempHero, String monsterChoice) {
        System.out.println("Le monstre a choisi l'action " + monsterChoice);
        System.out.println("Le type du monstre est : " + tempMonster.getType());
        switch (monsterChoice) {
            case "afk":
                System.out.println("Le monstre est afk");
                break;
            case "attack":
                System.out.println("Le monstre attaque");
                attack(tempMonster, tempHero);
                break;
            case "castMagic":
                System.out.println("Le monstre se soigne");
                tempMonster.regenHealthMag();
        }
    }

    private void endTurn(Opponent tempHero, Opponent tempMonster, String playerChoice, String monsterChoice) {
        if (Objects.equals(playerChoice, "defend")) {
            tempHero.resetDefense();
        }
        if (Objects.equals(monsterChoice, "defend")) {
            tempMonster.resetDefense();
        }
    }

    private void attack(Opponent attacker, Opponent defender) {
        int atk = attacker.getAttackPoint();
        int def = defender.getDefensePoint();
        int dmgDone = atk - def;

        if (dmgDone > 0) {
            defender.updateHealth(-dmgDone);
        } else {
            System.out.println(defender.getType() + "Defense Too Big !");
        }
    }
}
