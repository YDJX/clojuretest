package com.mythink.clojuretest.cljfn;

import clojure.lang.IFn;
import clojure.lang.RT;
import clojure.lang.Symbol;

/**
 * Created by SEELE on 2019/9/22.
 *
 * @author SEELE
 * @date 2019/9/22
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class CljInterop {

    private static IFn requireFn = RT.var("clojure.core", "require").fn();
    private static IFn randIntFn = RT.var("clojure.core", "rand-int").fn();

    static {
        requireFn.invoke(Symbol.intern("clojurebook.histogram"));
    }

    private static IFn frequencies = RT.var("clojure.core",  "frequencies").fn();
    private static Object keywords = RT.var("clojurebook.histogram", "keywords").deref();


    public static IFn getFrequencies() {
        return frequencies;
    }
    public static IFn getRandIntFn(){
        return randIntFn;
    }

    public static Object getKeywords() {
        return keywords;
    }

}
