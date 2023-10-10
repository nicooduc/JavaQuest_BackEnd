package com.epf.javaquest.services;

import com.epf.javaquest.DAO.HeroDao;
import com.epf.javaquest.models.Hero;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HeroService {
    private final HeroDao heroDao;

    public Hero getHero() {
        return heroDao.getHero();
    }
}
