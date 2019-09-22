package com.mythink.clojuretest.service.impl;

import clojure.lang.RT;
import clojure.lang.Var;
import com.mythink.clojuretest.service.DriverService;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by SEELE on 2019/9/22.
 *
 * @author SEELE
 * @date 2019/9/22
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
@Service("driverService")
public class DriverServiceImpl implements DriverService {

    @Override
    public Integer saveDriverName(String name) {
        try {
            RT.loadResourceScript("clojurebook/report.clj");
            Var report  = RT.var("clojurebook.report", "print-report");
            Integer result = ((Long) report.invoke(name)).intValue();
            System.out.println("saveDriverName result="+result  + ", name=" + name);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
