package com.loginstats.login_stats_api.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentYearMonthCountDto {
    private Integer year;
    private Integer month;
    private Integer totCnt;
    private String department;
}
