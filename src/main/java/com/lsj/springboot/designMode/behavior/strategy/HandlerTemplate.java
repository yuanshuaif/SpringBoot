package com.lsj.springboot.designMode.behavior.strategy;

import com.lsj.springboot.designMode.behavior.strategy.Handler.TypeHandler;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by 10326 on 2019/4/20.
 */
@Component
public class HandlerTemplate {

    private static final String DEFAULT_TYPE = "default";

    @Autowired
    private ApplicationContext applicationContext;

    public TypeHandler newHandlerInstance(String type){
        TypeHandler typeHandler = null;
        try {
            typeHandler = (TypeHandler)applicationContext.getBean(type);
        }catch (NoSuchBeanDefinitionException e){
            typeHandler = (TypeHandler)applicationContext.getBean(DEFAULT_TYPE);
        }
        return typeHandler;
    }

}
