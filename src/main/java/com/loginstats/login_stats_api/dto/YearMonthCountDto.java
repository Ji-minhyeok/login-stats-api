package com.loginstats.login_stats_api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class YearMonthCountDto {
    String yearMonth;
    Integer totCnt;
}