package com.epf.javaquest.DAO;

import com.epf.javaquest.models.Monster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonsterDao extends JpaRepository<Monster, Long> {

}
