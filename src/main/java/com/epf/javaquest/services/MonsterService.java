package com.epf.javaquest.services;

import com.epf.javaquest.DAO.MonsterDao;
import com.epf.javaquest.models.Monster;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Service gérant les opérations liées aux monstres.
 */
@Component
@RequiredArgsConstructor
public class MonsterService {
    private final MonsterDao monsterDao;

    /**
     * Récupère un monstre à partir de son identifiant.
     *
     * @param id L'identifiant du monstre à récupérer.
     * @return Le monstre correspondant à l'identifiant.
     */
    public Monster getMonsterById(long id) {
        return monsterDao.findById(id).orElse(null);
    }
}
