package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.StatisticsDao;
import com.takima.backskeleton.models.Statistics;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StatisticsService {
    private final StatisticsDao statisticsDao;

    public List<Statistics> getStatistics() {
        return statisticsDao.getAllStatistics();
    }
}
