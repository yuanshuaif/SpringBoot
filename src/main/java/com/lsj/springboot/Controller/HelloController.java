package com.lsj.springboot.Controller;

import com.lsj.springboot.Entity.ReadPropertiesPojo;
import com.lsj.springboot.Entity.UserAnnotation;
import com.lsj.springboot.springEvent.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

/**
 * Created by Administrator on 2018/12/9.
 */
@RestController
public class HelloController {
    @Value("${springboot.properties.name}")
    private String name;
    @Value("${springboot.properties.age}")
    private String age;
    @Autowired
    @Qualifier("readProperties")
    private ReadPropertiesPojo readPropertiesPojo;

    @Autowired
    private UserService userService;

    // springboot对日志的支持
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
    @RequestMapping("/hello")
    String home(Model model) {
        Map<String, Object> map = model.asMap();
        LOGGER.info(name+age+readPropertiesPojo.getName());
        LOGGER.debug(name+age+readPropertiesPojo.getName());
        LOGGER.error(name+age+readPropertiesPojo.getName());
        return "Hello World!";
    }

    @RequestMapping("/hello/{myName}")
    String index(@PathVariable String myName) {
        return "Hello "+myName+"!!!";
    }

    /**
     * post请求
     * @param userAnnotation
     * @return
     */
    @RequestMapping("/valid")
    String valid(@Valid @RequestBody UserAnnotation userAnnotation) {
        return userAnnotation.getName();
    }

    @RequestMapping("/register")
    public String register(){
        userService.register("xttblog.com");
        return "success";
    }

}
