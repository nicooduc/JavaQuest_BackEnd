package com.epf.javaquest.DAO;

import com.epf.javaquest.models.Monster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonsterDao extends JpaRepository<Monster, Long> {

}
