package com.epf.javaquest.DAO;

import com.epf.javaquest.models.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatisticsDao extends JpaRepository<Statistics, Long> {
    @Query(value = "SELECT s FROM Statistics s")
    List<Statistics> getAllStatistics();

}
