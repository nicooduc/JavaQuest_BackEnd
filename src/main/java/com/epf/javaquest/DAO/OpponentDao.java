package com.epf.javaquest.DAO;

import com.epf.javaquest.models.Opponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpponentDao extends JpaRepository<Opponent, Long> {
}
