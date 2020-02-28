package com.lsj.springboot.Filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by Administrator on 2019/2/26.
 * @WebFilter注解是通过bean的name来控制的
 */
@Component
@WebFilter(urlPatterns = "/*", filterName = "myfilter1")
public class Myfilter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("执行前:"+servletRequest.getParameterNames());
        filterChain.doFilter(servletRequest, servletResponse);
//        System.out.println("执行后:"+servletResponse.toString());
    }

    @Override
    public void destroy() {

    }
}
