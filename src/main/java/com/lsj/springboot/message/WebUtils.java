package com.lsj.springboot.message;

import javax.servlet.http.Cookie;

/**
 * Created by 10326 on 2019/11/17.
 */
public class WebUtils {
    public WebUtils() {
    }

    public static String getCookieValue(Cookie[] cookies, String key) {
        if(cookies != null) {
            Cookie[] arr$ = cookies;
            int len$ = cookies.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                Cookie cookie = arr$[i$];
                if(cookie.getName().equals(key)) {
                    return cookie.getValue();
                }
            }
        }

        return null;
    }
}
