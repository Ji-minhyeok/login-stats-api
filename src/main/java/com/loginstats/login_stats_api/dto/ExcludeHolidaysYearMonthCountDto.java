package com.loginstats.login_stats_api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ExcludeHolidaysYearMonthCountDto {
    private Integer year;
    private Integer month;
    private Integer totCnt;
    private Map<String,String> holidays;
}