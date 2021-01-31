package com.lsj.springboot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by 10326 on 2021/1/30.
 */
@Service
public class PcInformationServiceImpl implements PcInformationService{

    @Autowired
    private DistributedLock distributedLock;

    public JSONObject add() throws Exception {
        String key = "add_information_lock";
        String value = UUID.randomUUID().toString();
        JSONObject jsonObject = new JSONObject();
        long expireTime = 10L;

        boolean lock = distributedLock.lock1(key, value, expireTime);
        String threadName = Thread.currentThread().getName();
        if (lock) {
            System.out.println(threadName + " 获得锁...............................");
            Thread.sleep(30000);
            distributedLock.unLock(key, value);
            System.out.println(threadName + " 解锁了...............................");
        } else {
            System.out.println(threadName + " 未获取到锁...............................");
            return jsonObject.put("msg", "未获取的锁");
        }

        return jsonObject.put("msg", "获取的锁");
    }

}
