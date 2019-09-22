package com.mythink.clojuretest.cljfn;

import clojure.lang.IFn;
import com.mythink.clojuretest.cljutil.CljUtil;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;

import java.util.Map;

/**
 * Created by SEELE on 2018/3/17.
 *
 * @author SEELE
 * @date 2018/3/17
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class CljHoliday {

    private static final String cljNsHoliday = "holiday.client";

    public static final  String DOUBLE_EXP = "double-exp";

    static {
        CljUtil.requireNameSpace(cljNsHoliday);
    }

    public static Long holidayRewards(String gameID, String type, String[] usernames, int[] datas) {
        IFn cljHolidayRewards = CljUtil.referClojureFn(cljNsHoliday, "holiday-rewards");
        return (Long)cljHolidayRewards.invoke(gameID, type, usernames, datas);
    }


    public static JSONObject holidayStatus(String gameID, String type){
        IFn cljIsHolidayStatus = CljUtil.referClojureFn(cljNsHoliday, "holiday-status");
        Object status = cljIsHolidayStatus.invoke(gameID, type);
        JSONObject jsonObject = (JSONObject)JSONValue.parse(JSONObject.toJSONString((Map)status));
        return jsonObject;
    }
}
