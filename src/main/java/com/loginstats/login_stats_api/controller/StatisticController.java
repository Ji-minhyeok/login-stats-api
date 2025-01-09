package com.loginstats.login_stats_api.controller;

import com.loginstats.login_stats_api.dto.*;
import com.loginstats.login_stats_api.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StatisticController {

    @Autowired
    StatisticService statisticService;


    @RequestMapping(value="/api/v1/logins/year/{year}", produces = "application/json")
    @ResponseBody
    public Object getYearLoginCount(
            @PathVariable("year") String year){

        YearCountDto result = statisticService.getYearLogins(year);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.OK).body("No data");
        }
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value="/api/v1/logins/month/{yearMonth}", produces = "application/json")
    @ResponseBody
    public Object getYearMonthLoginCount(
            @PathVariable("yearMonth") String yearMonth){

        // yearMonth를 Year와 Month로 분리
        String year = yearMonth.substring(0, 4); // 앞 4자리: 연도
        String month = yearMonth.substring(4, 6); // 뒤 2자리: 월

        YearMonthCountDto result = statisticService.getYearMonthLogins(year, month);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.OK).body("No data");
        }
        return ResponseEntity.ok(result);
    }
    @RequestMapping(value="/api/v1/logins/average/month/{year}", produces = "application/json")
    @ResponseBody
    public Object getYearAverageLoginCount(
            @PathVariable("year") String year){

        YearAverageCountDto result = statisticService.getYearAverageLogins(year);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.OK).body("No data");
        }
        return ResponseEntity.ok(result);
    }
    @RequestMapping(value="/api/v1/logins/average/day/{yearMonth}", produces = "application/json")
    @ResponseBody
    public Object getYearMonthAverageLoginCount(
            @PathVariable("yearMonth") String yearMonth){

        // yearMonth를 Year와 Month로 분리
        String year = yearMonth.substring(0, 4); // 앞 4자리: 연도
        String month = yearMonth.substring(4, 6); // 뒤 2자리: 월

        YearMonthAverageCountDto result = statisticService.getYearMonthAverageLogins(year, month);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.OK).body("No data");
        }
        return ResponseEntity.ok(result);
    }
    @RequestMapping(value="/api/v1/logins/department/month/{yearMonth}", produces = "application/json")
    @ResponseBody
    public Object getDepartmentYearMonthLoginCount(
            @PathVariable("yearMonth") String yearMonth){

        // yearMonth를 Year와 Month로 분리
        String year = yearMonth.substring(0, 4); // 앞 4자리: 연도
        String month = yearMonth.substring(4, 6); // 뒤 2자리: 월

        List<DepartmentYearMonthCountDto> result = statisticService.getDepartmentYearMonthLogins(year, month);
        if (result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("No data");
        }
        return ResponseEntity.ok(result);
    }
}