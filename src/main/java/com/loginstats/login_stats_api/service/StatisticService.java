package com.loginstats.login_stats_api.service;

import com.loginstats.login_stats_api.dao.StatisticMapper;
import com.loginstats.login_stats_api.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONArray;
import org.json.JSONObject;
import java.net.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class StatisticService {

    private final RestTemplate restTemplate; //XML 관련 RestTemplate 활용
    private final String serviceKey;
    public StatisticService(RestTemplate restTemplate,
                            @Value("${environment.serviceKey}") String serviceKey ) {
        this.restTemplate = restTemplate;
        this.serviceKey = serviceKey;
    }
    @Autowired
    StatisticMapper statisticMapper;

    public YearCountDto getYearLogins(String year){

        return statisticMapper.selectYearLogin(year);
    }

    public YearMonthCountDto getYearMonthLogins(String year, String month){
        Map<String, String> params = new HashMap<>();
        params.put("year", year);
        params.put("month", month);
        return statisticMapper.selectYearMonthLogin(params);
    }
    public YearAverageCountDto getYearAverageLogins(String year){

        return statisticMapper.selectYearAverageLogin(year);

    }
    public YearMonthAverageCountDto getYearMonthAverageLogins(String year, String month){
        Map<String, String> params = new HashMap<>();
        params.put("year", year);
        params.put("month", month);
        return statisticMapper.selectYearMonthAverageLogin(params);
    }
    public List<DepartmentYearMonthCountDto> getDepartmentYearMonthLogins(String year, String month){
        Map<String, String> params = new HashMap<>();
        params.put("year", year);
        params.put("month", month);
        return statisticMapper.selectDepartmentYearMonthLogin(params);
    }
    public ExcludeHolidaysYearMonthCountDto getExcludeHolidaysYearMonthLogins(String year, String month) throws Exception {
        String holidaysJson = getHolidays(year, month); // 공휴일 정보 조회
        Map<String, String> holidays = parseHolidays(holidaysJson);

        // 2. 해당 월의 로그인 데이터 조회 (공휴일 제외)
        Integer totCnt = getLoginCountExcludeHolidays(year, month, holidays); // 로그인 제외된 데이터 카운트

        // 3. 결과 반환
        ExcludeHolidaysYearMonthCountDto result = new ExcludeHolidaysYearMonthCountDto();
        result.setYear(Integer.parseInt(year));
        result.setMonth(Integer.parseInt(month));
        result.setTotCnt(totCnt);
        result.setHolidays(holidays);

        return result;
    }

    public String getHolidays(String year, String month) throws URISyntaxException {
        // 이미 인코딩된 serviceKey를 그대로 사용
        String serviceKey = this.serviceKey;

        // URI 객체를 사용하여 URL을 구성
        String url = "http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService/getRestDeInfo"
                + "?serviceKey=" + serviceKey
                + "&pageNo=1"
                + "&numOfRows=31"
                + "&solYear=" + year
                + "&solMonth=" + month
                + "&_type=json";

        // URI 객체로 변환
        URI uri = new URI(url);

        // RestTemplate을 사용하여 요청
        System.out.println("Generated URL: " + uri.toString());
        String result = restTemplate.getForObject(uri, String.class);
        System.out.println(result);
        return result;
    }

    // 공휴일 정보 파싱
    public Map<String, String> parseHolidays(String json) {
        Map<String, String> holidaysMap = new HashMap<>();

        // JSON 문자열을 JSONObject로 변환
        JSONObject jsonObject = new JSONObject(json);
        System.out.println("json: " + json);
        System.out.println("jsonObject: " + jsonObject);

        // "response" 항목을 먼저 가져옴
        JSONObject response = jsonObject.getJSONObject("response");

        // "body" 항목에서 items 항목을 가져옴
        JSONObject body = response.getJSONObject("body");

        // "items"가 빈 문자열이거나 null일 경우 처리
        if (body.has("items") && !body.get("items").equals("")) {
            JSONObject items = body.getJSONObject("items");

            // "item"이 배열인지 단일 객체인지 확인 후 처리
            if (items.get("item") instanceof JSONArray) {
                // "item"이 배열일 경우
                JSONArray itemArray = items.getJSONArray("item");

                // item 배열을 순회하면서 locdate와 dateName 추출
                for (int i = 0; i < itemArray.length(); i++) {
                    JSONObject item = itemArray.getJSONObject(i);
                    Object locdateObj = item.get("locdate");// locdate는 숫자일 수도 있으므로 get()으로 가져옴
                    String locdate = locdateObj.toString(); // 숫자라면 문자열로 변환
                    String dateName = item.getString("dateName");

                    // locdate와 dateName을 맵에 저장
                    holidaysMap.put(locdate, dateName);
                }
            } else if (items.get("item") instanceof JSONObject) {
                // "item"이 단일 객체일 경우
                JSONObject item = items.getJSONObject("item");

                // locdate와 dateName 추출
                Object locdateObj = item.get("locdate"); // locdate는 숫자일 수도 있으므로 get()으로 가져옴
                String locdate = locdateObj.toString(); // 숫자라면 문자열로 변환
                String dateName = item.getString("dateName");

                // locdate와 dateName을 맵에 저장
                holidaysMap.put(locdate, dateName);
            }
        }
        return holidaysMap;
    }

    private Integer getLoginCountExcludeHolidays(String year, String month, Map<String, String> holidays) {
        // holidays 맵에서 공휴일 날짜들만 추출
        Set<String> holidayDates = holidays.keySet(); // 공휴일 날짜들

        // 2. 로그인 카운트를 공휴일을 제외한 데이터로 조회
        Map<String, Object> params = new HashMap<>();
        params.put("year", year);
        params.put("month", month);
        params.put("holidays", holidayDates); // holidays에 해당하는 날짜 제외

        return statisticMapper.selectExcludeHolidaysYearMonthLogin(params);
    }
}