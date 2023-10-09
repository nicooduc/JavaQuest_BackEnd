package com.takima.backskeleton.DAO;

import com.takima.backskeleton.models.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeroDao extends JpaRepository<Hero, Long> {
    @Query(value = "SELECT h FROM Hero h")
    List<Hero> getAllHeroes();

}
