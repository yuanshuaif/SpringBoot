package com.lsj.springboot.Util;

/**
 * Created by Administrator on 2019/2/24.
 */
public class day190224 {
    public static day190224 t1 = new day190224();
    {
        System.out.println("block A" + t1);
    }
    static{
        System.out.println("block B");
    }
    public static void main(String[] args){
        day190224 t2 = new day190224();
    }
}
