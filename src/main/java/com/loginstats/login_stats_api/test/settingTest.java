package com.loginstats.login_stats_api.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.loginstats.login_stats_api.dao.StatisticMapper;
import com.loginstats.login_stats_api.service.StatisticService;

@Controller
public class settingTest {

    @Autowired
    private StatisticService service;

    @ResponseBody
    @RequestMapping("/sqlyear-statistic")
    public Map<String, Object> sqltest(String year) throws Exception{

        return service.yearloginNum(year);
    }
    @RequestMapping("/test")
    public ModelAndView test() throws Exception{
        ModelAndView mav = new ModelAndView("test");
        mav.addObject("name", "devfunpj");
        List<String> resultList = new ArrayList<String>();
        resultList.add("!!!HELLO WORLD!!!");
        resultList.add("설정 TEST!!!");
        resultList.add("설정 TEST!!!");
        resultList.add("설정 TEST!!!!!");
        resultList.add("설정 TEST!!!!!!");
        mav.addObject("list", resultList);
        return mav;
    }

}