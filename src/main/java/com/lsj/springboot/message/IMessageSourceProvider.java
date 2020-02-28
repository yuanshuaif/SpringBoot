package com.lsj.springboot.message;

import java.util.Locale;

/**
 * Created by 10326 on 2019/11/17.
 */
public interface IMessageSourceProvider {
    String getMessage(String var1, Object[] var2, Locale var3);
}
