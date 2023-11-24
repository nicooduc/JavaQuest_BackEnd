package com.epf.javaquest.services;

import com.epf.javaquest.DAO.MonsterDao;
import com.epf.javaquest.models.Monster;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@RequiredArgsConstructor
public class MonsterService {
    private final MonsterDao monsterDao;

    //TODO classe probablement a supprimer

    public Monster getMonsterById(long id) {
        return monsterDao.findById(id).get();
    }

    /*
    classe à creer ? :
    equipItem
    unequipItem
    getInventory
     */
}
