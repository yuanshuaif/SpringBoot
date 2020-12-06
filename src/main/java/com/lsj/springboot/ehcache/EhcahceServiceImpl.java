package com.lsj.springboot.ehcache;

import net.sf.ehcache.util.ProductInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import javax.annotation.Resource;

/**
 * Created by 10326 on 2020/12/6.
 */
public class EhcahceServiceImpl implements EhcahceService {

    private static final String CACHE_STRATEGY = "local";

    @CachePut(value=CACHE_STRATEGY, key="'key_'+#info.getProduct_id()")
    @Override
    public ProductInfo saveProductInfo(ProductInfo info) throws Exception {
        return info;
    }
    //@CacheEvict(value="myCache", key="'get'+#userNo")
    // allEntries为true表示清除value中的全部缓存,默认为false
    // @CacheEvict(value="myCache", allEntries=true)
    @Cacheable(value=CACHE_STRATEGY, key="'key_'+#id")
    @Override
    public ProductInfo getProductInfoById(Long id) throws Exception {
        return null;
    }
}
