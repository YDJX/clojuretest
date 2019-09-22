package com.mythink.clojuretest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SEELE on 2019/4/1.
 *
 * @author SEELE
 * @date 2019/4/1
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class MyTest {

    @Test
    public void joinTest() {
        List<String> strings = new ArrayList<>();
        strings.add("aaa");
        strings.add("bbb");
        strings.add("ccc");
        System.out.println(String.join("," , strings));
    }
}
