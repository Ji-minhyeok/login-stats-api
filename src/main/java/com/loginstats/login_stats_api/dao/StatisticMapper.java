package com.loginstats.login_stats_api.dao;

import java.util.HashMap;

import com.loginstats.login_stats_api.dto.StatisticDto;
import com.loginstats.login_stats_api.dto.YearCountDto;
import com.loginstats.login_stats_api.dto.YearMonthCountDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StatisticMapper {

    YearCountDto selectYearLogin(String year);
    YearMonthCountDto selectYearMonthLogin(String yearMonth);

}