package com.lsj.springboot.controller;

import com.lsj.springboot.message.MultiLangContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 10326 on 2019/11/19.
 */
@RestController
public class MessageController {

    @RequestMapping(value = "/test" )
    String home() {
        String msg = MultiLangContext.getInstance().getMessage("common.exception");
        return msg;
    }
}
