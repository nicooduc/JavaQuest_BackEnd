package com.epf.javaquest.services;

import com.epf.javaquest.DAO.StatisticsDao;
import com.epf.javaquest.models.Statistics;
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
