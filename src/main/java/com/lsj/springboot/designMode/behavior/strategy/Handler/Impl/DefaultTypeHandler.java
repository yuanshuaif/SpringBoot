package com.lsj.springboot.designMode.behavior.strategy.Handler.Impl;

import com.lsj.springboot.designMode.behavior.strategy.Handler.TypeHandler;
import org.springframework.stereotype.Service;

/**
 * Created by 10326 on 2019/4/20.
 */
@Service("default")
public class DefaultTypeHandler implements TypeHandler {
    @Override
    public String dealMethodByType() {
        return "There are no beans of this type";
    }
}
