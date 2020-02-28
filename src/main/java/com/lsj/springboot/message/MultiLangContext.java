package com.lsj.springboot.message;

import org.springframework.util.StringUtils;

import java.util.Locale;

/**
 * Created by 10326 on 2019/11/17.
 */
public class MultiLangContext {

    public static MultiLangContext instance = new MultiLangContext();

    private MultiLangContext() {
    }

    public static MultiLangContext getInstance() {
        return instance;
    }

    public Locale getCurrentLocale() {
        String locale = InvocationInfoProxy.getLocale();
        if(StringUtils.isEmpty(locale)) {
            locale = "zh_CN";
        }

        return this.getLocaleByCode(locale);
    }

    private Locale getLocaleByCode(String langCode) {
        langCode = langCode.replace("-", "_");
        String[] languageRegion = langCode.split("_");
        String language = languageRegion[0];
        String region = "";
        if(languageRegion.length > 1) {
            region = languageRegion[1];
        }

        return new Locale(language, region);

    }

    public String getMessage(String key, Object... params) {
        Locale locale = this.getCurrentLocale();
        String message = null;

        try {
            message = MessageSourceProviderHolder.getMessageSourceProvider().getMessage(key, params, locale);
        } catch (Exception var6) {
            var6.printStackTrace();
        }

        return !StringUtils.isEmpty(message) ? message : key;
    }


}
