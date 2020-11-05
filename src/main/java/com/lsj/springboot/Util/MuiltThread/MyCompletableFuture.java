package com.lsj.springboot.Util.MuiltThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by 10326 on 2020/2/12.
 */
public class MyCompletableFuture {

    public static void main(String[] args){
        ExecutorService executor = Executors.newFixedThreadPool(2);
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() ->{
            System.out.println("爸：小红你去买瓶酒！");
            try {
                System.out.println("小红出去买酒了，女孩子跑的比较慢，估计5s后才会回来...");
                Thread.sleep(5000);
                return "我买回来了！";
            } catch (InterruptedException e) {
                System.err.println("小红路上遭遇了不测");
                return "来世再见！";
            }
        }, executor);
        System.out.println("-----");
//        future.thenAccept((msg) -> {System.out.println(msg);});
        try {
            String msg = future.get();
            System.out.println(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
        List<String> list = new ArrayList<>();
        sub(list);
    }

    public static void sub(List<? extends Object> lists){

    }

}
