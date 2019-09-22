package com.mythink.clojuretest.cljutil;

import clojure.java.api.Clojure;
import clojure.lang.IFn;

/**
 * Created by SEELE on 2018/3/17.
 *
 * @author SEELE
 * @date 2018/3/17
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class CljUtil {

    public static final IFn require = Clojure.var("clojure.core", "require") ;

    public static final void requireNameSpace(String ns) {
        require.invoke(Clojure.read(ns));
    }

    public static final IFn referClojureFn(String ns, String fn) {
        return Clojure.var(ns, fn);
    }
}
