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
import java.util.Random;

@Component
@RequiredArgsConstructor
public class FightService {
    private final OpponentDao opponentDao;
    private final MonsterDao monsterDao;
    private final HeroDao heroDao;

    /**
     * Effectue un tour de combat en fonction de l'action choisie par le joueur.
     *
     * @param actionHero Action choisie par le joueur.
     * @return Liste des opposants mise à jour.
     */
    public List<OpponentDto> turn(String actionHero) {
        int heroIndex;
        int monsterIndex;
        String actionMonster = actionMonster();
        List<Opponent> opponents = opponentDao.findAll();
        heroIndex = opponents.get(0).getType().equals("Hero") ? 0 : 1;
        monsterIndex = 1 - heroIndex;
        Opponent tempHero = opponents.get(heroIndex);
        Opponent tempMonster = opponents.get(monsterIndex);
        int speedHero = opponents.get(heroIndex).getSpeed();
        int speedMonster = opponents.get(monsterIndex).getSpeed();


        if (Objects.equals(actionHero, "defend")) {
            tempHero.choiceDefense();
        }
        if (Objects.equals(actionMonster, "defend")) {
            tempMonster.choiceDefense();
        }

        if (speedMonster <= speedHero) {
            actionPlayer(tempHero, tempMonster, actionHero);
            actionMonster(tempMonster, tempHero, actionMonster);
        } else {
            actionMonster(tempMonster, tempHero, actionMonster);
            actionPlayer(tempHero, tempMonster, actionHero);
        }
        endTurn(tempHero, tempMonster, actionHero, actionMonster);
        opponentDao.save(tempHero);
        opponentDao.save(tempMonster);
        return OpponentMapper.toDtoList(opponentDao.findAll());
    }

    /**
     * Termine le combat en fonction du résultat (victoire ou défaite) et attribue l'expérience au héros.
     *
     * @param success Indique si le combat a été remporté.
     * @return Gain d'expérience.
     */
    public Integer endFight(boolean success) {
        List<Opponent> opponents = opponentDao.findAll();
        int heroIndex = opponents.get(0).getType().equals("Hero") ? 0 : 1;
        int monsterIndex = 1 - heroIndex;

        Hero hero = getHeroFromOpponent(opponents.get(heroIndex));
        Monster monster = monsterDao.findById(opponents.get(monsterIndex).getOrigin_id()).orElseThrow(() -> new RuntimeException("Monster not found"));
        int expGain = monster.getXpDrop();

        if (success) {
            expGain = hero.updateExp(expGain);
            heroDao.save(hero);
        } else {
            //heroDao.deleteById(1L); // update 0 if multiple heroes available
            heroDao.deleteAll();
            heroDao.save(Hero.createHero(hero.getName(), 1));
            expGain = 0;
        }
        opponentDao.deleteAll();
        return expGain;
    }

    /**
     * Récupère le héros à partir d'un opposant.
     *
     * @param opponent Opposant représentant le héros.
     * @return Héros correspondant.
     */
    private Hero getHeroFromOpponent(Opponent opponent) {
        return heroDao.findById(opponent.getOrigin_id()).orElseThrow(() -> new RuntimeException("Hero not found"));
    }

    /**
     * Génère une action aléatoire pour un monstre lors de son tour.
     * Les actions possibles sont : "defend" (défendre), "attack" (attaquer), "castMagic" (lancer une attaque magique),
     * et "afk" (ne rien faire).
     *
     * @return Action générée aléatoirement pour le monstre.
     */
    private String actionMonster() {
        Random random = new Random();
        return switch (random.nextInt(4)) {
            case 0 -> "defend";
            case 1 -> "attack";
            case 2 -> "castMagic";
            default -> "afk";
        };
    }

    /**
     * Effectue l'action choisie par le joueur pendant son tour.
     *
     * @param tempHero     Le héros effectuant l'action.
     * @param tempMonster  L'adversaire du héros.
     * @param playerChoice L'action choisie par le joueur ("attack" ou "castMagic").
     */
    private void actionPlayer(Opponent tempHero, Opponent tempMonster, String playerChoice) {
        switch (playerChoice) {
            case "attack":
                attack(tempHero, tempMonster);
                break;
            case "castMagic":
                tempHero.regenHealthMag();
                break;
        }
    }

    /**
     * Effectue l'action choisie par le monstre pendant son tour.
     *
     * @param tempMonster   Le monstre effectuant l'action.
     * @param tempHero      L'adversaire du monstre (héros).
     * @param monsterChoice L'action choisie par le monstre ("afk", "attack" ou "castMagic").
     */
    private void actionMonster(Opponent tempMonster, Opponent tempHero, String monsterChoice) {
        switch (monsterChoice) {
            case "afk":
                break;
            case "attack":
                attack(tempMonster, tempHero);
                break;
            case "castMagic":
                tempMonster.regenHealthMag();
        }
    }


    /**
     * Termine le tour en réinitialisant les effets de défense pour le héros et le monstre.
     *
     * @param tempHero      Le héros dont le tour est terminé.
     * @param tempMonster   Le monstre dont le tour est terminé.
     * @param playerChoice  L'action choisie par le joueur pendant son tour.
     * @param monsterChoice L'action choisie par le monstre pendant son tour.
     */
    private void endTurn(Opponent tempHero, Opponent tempMonster, String playerChoice, String monsterChoice) {
        if (Objects.equals(playerChoice, "defend")) {
            tempHero.resetDefense();
        }
        if (Objects.equals(monsterChoice, "defend")) {
            tempMonster.resetDefense();
        }
    }

    /**
     * Effectue une attaque entre un attaquant et un défenseur en prenant en compte la défense du défenseur.
     *
     * @param attacker L'attaquant effectuant l'attaque.
     * @param defender Le défenseur subissant l'attaque.
     */
    private void attack(Opponent attacker, Opponent defender) {
        int atk = attacker.getAttackPoint();
        int def = defender.getDefensePoint();
        int dmgDone = atk - def;

        if (dmgDone > 0) {
            defender.updateHealth(-dmgDone);
        }
    }
}
