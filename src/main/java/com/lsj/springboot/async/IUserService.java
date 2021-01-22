package com.lsj.springboot.async;

import com.lsj.springboot.entity.UserAnnotation;

/**
 * Created by 10326 on 2020/4/4.
 */
public interface IUserService {

    void save(UserAnnotation user);
    Boolean senMsg(UserAnnotation user);
}
