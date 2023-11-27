package com.epf.javaquest.services;

import com.epf.javaquest.DAO.HeroDao;
import com.epf.javaquest.models.Hero;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Service gérant les opérations liées au héros.
 */
@Component
@RequiredArgsConstructor
public class HeroService {
    private final HeroDao heroDao;

    /**
     * Génère un nouveau héros avec le nom et le niveau spécifiés.
     *
     * @param name  Le nom du héros.
     * @param level Le niveau du héros.
     * @return Le héros généré et sauvegardé dans la base de données.
     */
    public Hero generateHero(String name, int level) {
        Hero hero = Hero.createHero(name, level);
        return heroDao.save(hero);
    }

    /**
     * Récupère un héros à partir de son identifiant.
     *
     * @param id L'identifiant du héros à récupérer.
     * @return Le héros correspondant à l'identifiant.
     */
    public Hero getHeroById(long id) {
        return heroDao.findById(id).orElse(null);
    }

    /**
     * Supprime le héros spécifié de la base de données.
     *
     * @param hero Le héros à supprimer.
     * @return Un code de statut indiquant le résultat de l'opération (0 pour succès).
     */
    public int deleteHero(Hero hero) {
        heroDao.delete(hero);
        return 0;
    }
}
