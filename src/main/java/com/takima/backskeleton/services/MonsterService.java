package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.MonsterDao;
import com.takima.backskeleton.models.Monster;
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
