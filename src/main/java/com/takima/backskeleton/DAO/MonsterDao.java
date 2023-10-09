package com.takima.backskeleton.DAO;

import com.takima.backskeleton.models.Monster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonsterDao extends JpaRepository<Monster, Long> {
    @Query(value = "SELECT m FROM Monster m")
    List<Monster> getAllMonsters();

}
