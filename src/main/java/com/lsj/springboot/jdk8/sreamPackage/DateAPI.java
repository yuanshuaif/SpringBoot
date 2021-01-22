package com.lsj.springboot.jdk8.sreamPackage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Created by 10326 on 2020/2/28.
 */
public class DateAPI {
    public static void main(String[] args){
        test1();
    }

    /**
     * 实际使用中，计算日期就用LocalDate,计算日期加时刻用LocalDateTime，如果只有时刻就是LocalTime
     * DateTimeFormatter
     */
    private static void test1(){
        // 1获取当前时间的对象
        LocalDate localDate = LocalDate.now();
        // 2.从字符串中解析
        String localDatStr  = localDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        System.out.println(localDatStr);
        LocalDate localDate1 = LocalDate.parse(localDatStr, DateTimeFormatter.ofPattern("yyyyMMdd"));
        System.out.println(localDate1.toString());
        // 3 LocalDate比Date更强的初始化时间
        LocalDate localDate2 = LocalDate.of(2019,1,12);
        System.out.println(localDate2.toString());
        // 4.加减时间更好的理解和操作
        LocalDate localDate3 = localDate.plusDays(2);
        System.out.println(localDate3.toString());
        // 5.localDate至localDate3之间相差多少天
        long dateNum = localDate.until(localDate3, ChronoUnit.DAYS);
        System.out.println(dateNum);
    }
}
