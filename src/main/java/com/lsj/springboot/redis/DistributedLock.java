package com.lsj.springboot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by 10326 on 2021/1/30.
 */
@Component
public class DistributedLock {
//    @Autowired
//    https://blog.csdn.net/zhaoheng314/article/details/81564166
    @Resource
    private RedisTemplate<Serializable, Object> redisTemplate;
    private static final Long RELEASE_SUCCESS = 1L;
    private static final Long POSTPONE_SUCCESS = 1L;

    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "EX";
    // 解锁脚本(lua)
    private static final String RELEASE_LOCK_SCRIPT = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
    // 延时脚本
    private static final String POSTPONE_LOCK_SCRIPT = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('expire', KEYS[1], ARGV[2]) else return '0' end";

    /**
     * 分布式锁
     * @param key
     * @param value
     * @param expireTime 单位: 秒
     * @return
     */
    public boolean lock(String key, String value, long expireTime) {
        return redisTemplate.execute((RedisCallback<Boolean>) redisConnection -> {
            Jedis jedis = (Jedis) redisConnection.getNativeConnection();
            String result = jedis.set(key, value, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
            if (LOCK_SUCCESS.equals(result)) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        });
    }

    /**
     * 解锁
     * @param key
     * @param value
     * @return
     */
    public Boolean unLock(String key, String value) {
        return redisTemplate.execute((RedisCallback<Boolean>) redisConnection -> {
            Jedis jedis = (Jedis) redisConnection.getNativeConnection();
            Object result = jedis.eval(RELEASE_LOCK_SCRIPT, Collections.singletonList(key), Collections.singletonList(value));
            if (RELEASE_SUCCESS.equals(result)) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        });
    }

    /**
     * 分布式锁
     * @param key
     * @param value
     * @param expireTime 单位: 秒
     * @return
     */
    public boolean lock1(String key, String value, long expireTime) {
        // 加锁
        Boolean locked = redisTemplate.execute((RedisCallback<Boolean>) redisConnection -> {
            Jedis jedis = (Jedis) redisConnection.getNativeConnection();
            String result = jedis.set(key, value, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
            if (LOCK_SUCCESS.equals(result)) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        });

        if (locked) {
            // 加锁成功, 启动一个延时线程, 防止业务逻辑未执行完毕就因锁超时而使锁释放
            PostponeTask postponeTask = new PostponeTask(key, value, expireTime, this);
            Thread thread = new Thread(postponeTask);
            thread.setDaemon(Boolean.TRUE);
            thread.start();
        }

        return locked;
    }


    /**
     * 锁延时
     * @param key
     * @param value
     * @param expireTime
     * @return
     */
    public Boolean postpone(String key, String value, long expireTime) {
        return redisTemplate.execute((RedisCallback<Boolean>) redisConnection -> {
            Jedis jedis = (Jedis) redisConnection.getNativeConnection();
            Object result = jedis.eval(POSTPONE_LOCK_SCRIPT, new ArrayList<String>(){{add(key);}},
                    new ArrayList<String>(){{add(value);add(String.valueOf(expireTime));}});
            if (POSTPONE_SUCCESS.equals(result)) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        });
    }

}
