package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.HeroDao;
import com.takima.backskeleton.models.Hero;
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
