package com.epf.javaquest.services;

import com.epf.javaquest.DAO.MonsterDao;
import com.epf.javaquest.models.Monster;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MonsterService {
    private final MonsterDao monsterDao;

    public List<Monster> getAllMonsters() {
        return monsterDao.getAllMonsters();
    }
}
