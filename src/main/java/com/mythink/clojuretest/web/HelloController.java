package com.mythink.clojuretest.web;

import clojure.java.api.Clojure;
import clojure.lang.IFn;
import clojure.lang.Keyword;
import com.mythink.clojuretest.cljfn.CljHoliday;
import com.mythink.clojuretest.cljfn.CljInterop;
import com.mythink.clojuretest.cljutil.CljUtil;
import com.mythink.clojuretest.service.DriverService;
import com.mythink.clojuretest.vo.BaseResultVO;
import net.minidev.json.JSONObject;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by SEELE on 2018/3/17.
 *
 * @author SEELE
 * @date 2018/3/17
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
@RestController
public class HelloController {

    private static Pattern EMPTY_PATTERN = Pattern.compile(" ");

    @Resource
    private DriverService driverService;

    @RequestMapping("/")
    public String index() {
        String[] usernames = null;
        int[] datas = null;
//        return "Getting from Spring Boot 2." + CljHoliday.holidayRewards("aa", "1", usernames, datas);
        IFn plus = Clojure.var("clojure.core", "+");
        Long result = (Long)plus.invoke(2, 3);
        IFn split = Clojure.var("clojure.string", "split");
        List<String> strList = (List<String>)split.invoke("hello world this is a test", EMPTY_PATTERN);
        CljUtil.requireNameSpace("holiday.client");
        IFn reward = Clojure.var("holiday.client", "holiday-rewards");
        Object object = reward.invoke("aa", "1", null, null);
        return "GETting from Spring boot "+result + strList.get(1) + CljHoliday.holidayRewards("aa", "1", usernames, datas)+ object;

    }

    @RequestMapping("/data")
    @ResponseBody
    public JSONObject getData() {
        JSONObject jsonObject = CljHoliday.holidayStatus("123", "2");
        return jsonObject;
    }

    @RequestMapping("rand")
    public Integer getIndex() {
        Map<Keyword, Integer> sampleHistogram = (Map<Keyword, Integer>) CljInterop.getFrequencies().invoke(CljInterop.getKeywords());
        System.out.println("Number of :a keywords in sample histogram: "+ sampleHistogram.get(Keyword.intern("a")));
        System.out.println("Complete sample histogram: " + sampleHistogram);
        System.out.println();
        System.out.println("histogram of chars in 'I left my heart in san fransisco': " + CljInterop.getFrequencies().invoke("I left my heart in san fransisco".toLowerCase()));
        System.out.println();
        ArrayList randomInts = new ArrayList();
        for (int i = 0; i < 500; i++) {
            randomInts.add(CljInterop.getRandIntFn().invoke(10));
        }
        System.out.println("Histogram of 500 random ints [0,10]: "+ CljInterop.getFrequencies().invoke(randomInts));
        return (Integer) CljInterop.getRandIntFn().invoke(500);
    }

    @RequestMapping("driver/name")
    @ResponseBody
    public BaseResultVO<Integer> saveUserName(@RequestParam(name = "name") String name) {
        if (StringUtils.isEmpty(name)) {
            name = "defaultName";
        }
        Integer driverName = driverService.saveDriverName(name);
        BaseResultVO<Integer> baseResultVO = new BaseResultVO<>();
        baseResultVO.setCode(200);
        baseResultVO.setMessage("成功");
        baseResultVO.setSuccess(true);
        baseResultVO.setData(driverName);
        return baseResultVO;
    }
}
