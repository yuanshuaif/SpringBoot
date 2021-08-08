package com.lsj.springboot.redis;

/**
 * Created by 10326 on 2021/8/8.
 * 获取库存回调
 */
public interface IStockCallback {
    /**
     * 获取库存
     * @return
     */
    int getStock();
}
