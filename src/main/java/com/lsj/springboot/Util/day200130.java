package com.lsj.springboot.Util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by 10326 on 2020/1/30.
 * try-catch-finally
 * LinkedHashMap
 */
public class day200130 {
    @SuppressWarnings("finally")
    public static final String test() {
        String t = "";

        try {
            t = "try"; // 1
            // class 文件部分
           /* String e = t;// 2
            return e; // 4*/
            return t;
        } catch (Exception e) {
            // result = "catch";
            t = "catch";
            return t;
        } finally {
            t = "finally";//3
        }
    }

    public static int test0() {
        int b = 20;

        try {
            System.out.println("try block");

            return b += 80;
        }
        catch (Exception e) {

            System.out.println("catch block");
        }
        finally {

            System.out.println("finally block");

            if (b > 25) {
                System.out.println("b>25, b = " + b);
            }
        }

        return b;
    }

    @SuppressWarnings("finally")
    public static final String test1() {
        String t = "";

        try {
            t = "try";
            return t;
        } catch (Exception e) {
            // result = "catch";
            t = "catch";
            return t;
        } finally {
            t = "finally";
            return t;
        }
    }

    @SuppressWarnings("finally")
    public static final String test2() {
        String t = "";

        try {
            t = "try";
            Integer.parseInt(null);
            return t;
        } catch (Exception e) {
            t = "catch";
            return t;
        } finally {
            t = "finally";
            // System.out.println(t);
            // return t;
        }
    }

    @SuppressWarnings("finally")
    public static final String test3() {
        String t = "";

        try {
            t = "try";
            Integer.parseInt(null);
            return t;
        } catch (Exception e) {
            t = "catch";
            Integer.parseInt(null);
            return t;
        } finally {
            t = "finally";
            //return t;
        }
    }

    @SuppressWarnings("finally")
    public static final String test4() {
        String t = "";

        try {
            t = "try";
            Integer.parseInt(null);
            return t;
        } catch (Exception e) {
            t = "catch";
            Integer.parseInt(null);
            return t;
        } finally {
            t = "finally";
            return t;
        }
    }
    @SuppressWarnings("finally")
    public static final String test5() {
        String t = "";

        try {
            t = "try";
            Integer.parseInt(null);
            return t;
        } catch (NullPointerException e) {
            t = "catch";
            return t;
        } finally {
            t = "finally";
        }
    }

    @SuppressWarnings("finally")
    public static final String test6() {
        String t = "";

        try {
            t = "try";
            Integer.parseInt(null);
            return t;
        } catch (NullPointerException e) {
            t = "catch";
            return t;
        } finally {
            t = "finally";
            return t;
        }
    }

    @SuppressWarnings("finally")
    public static final String test7() {
        String t = "";

        try {
            t = "try";return t;
        } catch (Exception e) {
            t = "catch";
            return t;
        } finally {
            t = "finally";
            String.valueOf(null);
            return t;
        }
    }

    /**
     * LinkedHashMap
     * @return
     */
    public static final void test8() {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(16, 0.75f, true);
        for (int i = 0; i < 10; i++) {
            map.put(i, i);
        }

        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        map.get(3);
        System.out.println("-----------");
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
    public static Map<String, String> getMap() {
        Map<String, String> map = new HashMap<>();
        map.put("KEY", "INIT");

        try {
            map.put("KEY", "TRY");
            return map;
        }
        catch (Exception e) {
            map.put("KEY", "CATCH");
        }
        finally {
            // 操作的是值修改有效
            map.put("KEY", "FINALLY");
            // 操作引用修改无效
            map = null;
        }

        return map;
    }
    public static void main(String[] args) {
        /*System.out.println(day200130.test());
        System.out.println(day200130.test0());
        System.out.println(day200130.test1());
        System.out.println(day200130.test2());
        System.out.println(day200130.test4());
        System.out.println(day200130.test6());*/
//        System.out.println(day200130.test0());
        System.out.println(getMap().get("KEY").toString());
//        test8();


    }
}
