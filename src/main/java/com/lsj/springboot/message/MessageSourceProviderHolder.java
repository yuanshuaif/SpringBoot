package com.lsj.springboot.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by 10326 on 2019/11/17.
    如果三种注入方式都被使用了，最终生效的是设值注入； 他们之间的顺序是 构造注入 > 属性注入 > 设值注入
    构造注入发生在Bean生命周期的实例化阶段，不是发生在填充属性阶段（调用时触发）
    属性注入和设值注入都是发生在Bean生命周期的填充属性阶段，且属性注入发生在设置注入之前
 */
@Component
public class MessageSourceProviderHolder {

    private static IMessageSourceProvider msProvider;

   /* @Autowired
    public MessageSourceProviderHolder(IMessageSourceProvider messageSourceProvider) {
        msProvider = messageSourceProvider;
    }*/

    /**
     * 为了能够拿到spring容器管理的对象
     * @return
     */
    public static IMessageSourceProvider getMessageSourceProvider() {
        return msProvider;
    }

    @Autowired
    public void setMessageSourceProvider(IMessageSourceProvider messageSourceProvider) {
        msProvider = messageSourceProvider;
    }

}
