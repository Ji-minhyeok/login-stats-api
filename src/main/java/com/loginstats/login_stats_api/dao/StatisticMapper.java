package com.loginstats.login_stats_api.dao;

import java.util.HashMap;

import com.loginstats.login_stats_api.dto.StatisticDto;
public interface StatisticMapper {
    public HashMap<String, Object> selectYearLogin(String year);

}