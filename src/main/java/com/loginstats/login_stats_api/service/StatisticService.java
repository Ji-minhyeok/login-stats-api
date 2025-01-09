package com.loginstats.login_stats_api.service;

import com.loginstats.login_stats_api.dao.StatisticMapper;
import com.loginstats.login_stats_api.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StatisticService {


    @Autowired
    StatisticMapper statisticMapper;

    public YearCountDto getYearLogins(String year){

        return statisticMapper.selectYearLogin(year);
    }

    public YearMonthCountDto getYearMonthLogins(String year, String month){
        Map<String, String> params = new HashMap<>();
        params.put("year", year);
        params.put("month", month);
        return statisticMapper.selectYearMonthLogin(params);
    }
    public YearAverageCountDto getYearAverageLogins(String year){

        return statisticMapper.selectYearAverageLogin(year);

    }
    public YearMonthAverageCountDto getYearMonthAverageLogins(String year, String month){
        Map<String, String> params = new HashMap<>();
        params.put("year", year);
        params.put("month", month);
        return statisticMapper.selectYearMonthAverageLogin(params);
    }
    public List<DepartmentYearMonthCountDto> getDepartmentYearMonthLogins(String year, String month){
        Map<String, String> params = new HashMap<>();
        params.put("year", year);
        params.put("month", month);
        return statisticMapper.selectDepartmentYearMonthLogin(params);
    }
}