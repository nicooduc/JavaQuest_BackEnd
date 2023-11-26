package com.epf.javaquest.services;

import com.epf.javaquest.DAO.HeroDao;
import com.epf.javaquest.models.Hero;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HeroService {
    private final HeroDao heroDao;

    //classe pour l'affichage des stats du hero hors combat

    public Hero generateHero(String name, int level) {
        Hero hero = Hero.createHero(name, level);
        return heroDao.save(hero);
    }

    public Hero getHeroById(long id) {
        return heroDao.findById(id).get();
    }

    public int deleteHero(Hero hero) {
        heroDao.delete(hero);
        return 0;
    }
}
