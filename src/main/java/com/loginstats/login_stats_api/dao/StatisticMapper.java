package com.loginstats.login_stats_api.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.loginstats.login_stats_api.dto.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StatisticMapper {

    YearCountDto selectYearLogin(String year);
    YearMonthCountDto selectYearMonthLogin(Map<String, String> params);
    YearAverageCountDto selectYearAverageLogin(String year);
    YearMonthAverageCountDto selectYearMonthAverageLogin(Map<String, String> params);
    List<DepartmentYearMonthCountDto> selectDepartmentYearMonthLogin(Map<String, String> params);
}