package com.lsj.springboot.ehcache;

import net.sf.ehcache.util.ProductInfo;

/**
 * Created by 10326 on 2020/12/6.
 */
public interface EhcahceService {
    ProductInfo saveProductInfo(ProductInfo info) throws Exception;
    ProductInfo getProductInfoById(Long id) throws Exception;
}
