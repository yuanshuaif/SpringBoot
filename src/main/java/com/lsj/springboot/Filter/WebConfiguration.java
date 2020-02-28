package com.lsj.springboot.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/2/26.
 */
@Configuration
public class WebConfiguration {

    @Bean
    public FilterRegistrationBean filterRegistration(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new myfilter2());
        List urlList = new ArrayList();
        urlList.add("/*");
        filterRegistrationBean.setUrlPatterns(urlList);
        filterRegistrationBean.setOrder(2);
        return filterRegistrationBean;
    }

    public class myfilter2 implements Filter {
        @Override
        public void init(FilterConfig filterConfig) throws ServletException {

        }

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            System.out.println("myfilter2执行前1");
            filterChain.doFilter(servletRequest, servletResponse);
//            System.out.println("myfilter2执行后2");
        }

        @Override
        public void destroy() {

        }
    }
}
