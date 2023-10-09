package com.takima.backskeleton.DAO;

import com.takima.backskeleton.models.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatisticsDao extends JpaRepository<Statistics, Long> {
    @Query(value = "SELECT s FROM Statistics s")
    List<Statistics> getAllStatistics();

}
