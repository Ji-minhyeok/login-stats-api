package com.loginstats.login_stats_api.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class YearMonthAverageCountDto {
    private Integer year;
    private Integer month;
    private Double totCnt;
}
