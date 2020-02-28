package com.lsj.springboot.Util.MuiltThread;

import java.util.Random;

/**
 * Created by 10326 on 2019/5/12.
 */
public class FetchMoneyTest {

    public static void main(String[] args){
        Bank bank = new Bank();

        Thread t1 = new MoneyThread(bank);// 从银行取钱
        Thread t2 = new MoneyThread(bank);// 从取款机取钱

        t1.start();
        t2.start();

    }
}

class Bank{
    private int money = 1000;// 在jvm -server的服务器上运行才会出现线程不共享的情况

    public int getMoney(int number){
        if (number < 0){
            return -1;
        }
        else if (number > money){
            return -2;
        }
        else if (money < 0) {
            return -3;
        }
        else{
            try{
                Thread.sleep((long) Math.random() * 500);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            money -= number;

            System.out.println("Left Money: " + money);
            return number;

        }
    }
}

class MoneyThread extends Thread{

    private Bank bank;

    public MoneyThread(Bank bank){
        this.bank = bank;
    }

    @Override
    public void run(){
        System.out.println(bank.getMoney(800));
    }
}
