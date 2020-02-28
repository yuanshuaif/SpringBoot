package com.lsj.springboot.message;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * Created by 10326 on 2019/11/17.
 */
@Component
public class MessageSourceProvider implements IMessageSourceProvider, ApplicationContextAware {

    /** spring 容器 */
    private static ApplicationContext appContext;

    @Override
    public String getMessage(String key, Object[] params, Locale locale) {
        return appContext.getMessage(key, params, locale);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.appContext = applicationContext;
    }
}
