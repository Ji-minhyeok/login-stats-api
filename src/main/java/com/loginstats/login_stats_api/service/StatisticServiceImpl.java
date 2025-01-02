package com.loginstats.login_stats_api.service;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginstats.login_stats_api.dao.StatisticMapper;

@Service
public class StatisticServiceImpl implements StatisticService {


    @Autowired
    private StatisticMapper uMapper;

    @Override
    public HashMap<String, Object> yearloginNum (String year) {
        // TODO Auto-generated method stub
        System.out.println("uMapper is not null: " + (uMapper != null));  // uMapper가 null이 아닌지 확인
        HashMap<String, Object> retVal = new HashMap<String,Object>();

        try {
            // 쿼리 실행 결과 확인
            HashMap<String, Object> queryResult = uMapper.selectYearLogin(year);
            System.out.println("Query result: " + queryResult);  // 쿼리 결과를 로그에 출력

            if (queryResult != null && !queryResult.isEmpty()) {
                retVal = queryResult;
                retVal.put("year", year);
                retVal.put("is_success", true);
            } else {
                retVal.put("totCnt", 0);  // 결과가 없을 경우 기본값 설정
                retVal.put("year", year);
                retVal.put("is_success", false);
            }
        } catch (Exception e) {
            retVal.put("totCnt", -999);
            retVal.put("year", year);
            retVal.put("is_success", false);
            e.printStackTrace();  // 예외 발생 시 스택 트레이스를 출력하여 문제 파악
        }

        return retVal;
    }

}