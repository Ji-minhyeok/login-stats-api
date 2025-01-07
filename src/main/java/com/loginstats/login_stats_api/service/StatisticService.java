package com.loginstats.login_stats_api.service;

import com.loginstats.login_stats_api.dao.StatisticMapper;
import com.loginstats.login_stats_api.dto.YearCountDto;
import com.loginstats.login_stats_api.dto.YearMonthCountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticService {


    @Autowired
    StatisticMapper statisticMapper;

    public YearCountDto getYearLogins(String year){

        return statisticMapper.selectYearLogin(year);
    }

    public YearMonthCountDto getYearMonthLogins(String year, String month){

        return statisticMapper.selectYearMonthLogin(year+month);
    }



}