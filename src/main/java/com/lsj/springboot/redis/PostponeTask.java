package com.lsj.springboot.redis;

/**
 * Created by 10326 on 2021/1/31.
 */
public class PostponeTask implements Runnable {
    private String key;
    private String value;
    private long expireTime;
    private boolean isRunning;
    private DistributedLock distributedLock;

    public PostponeTask() {
    }

    public PostponeTask(String key, String value, long expireTime, DistributedLock distributedLock) {
        this.key = key;
        this.value = value;
        this.expireTime = expireTime;
        this.isRunning = Boolean.TRUE;
        this.distributedLock = distributedLock;
    }

    @Override
    public void run() {
        long waitTime = expireTime * 1000 * 2 / 3;// 线程等待多长时间后执行
        while (isRunning) {
            try {
                Thread.sleep(waitTime);
                if (distributedLock.postpone(key, value, expireTime)) {
                    System.out.println("延时成功...........................................................");
                } else {
                    System.out.println("stop...........................................................");
                    this.stop();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void stop() {
        this.isRunning = Boolean.FALSE;
    }
}
