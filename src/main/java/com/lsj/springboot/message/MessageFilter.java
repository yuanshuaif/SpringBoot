package com.lsj.springboot.message;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Administrator on 2019/2/17.
 */
@Component
@WebFilter(urlPatterns = "/*", filterName = "messageFilter")
public class MessageFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest hReq = (HttpServletRequest)servletRequest;
        String localeCode = hReq.getParameter("lang");
        if(StringUtils.isEmpty(localeCode)) {
            hReq.getCookies();
            localeCode = WebUtils.getCookieValue(hReq.getCookies(), "locale");
        }

        if(StringUtils.isEmpty(localeCode)) {
            localeCode = "zh_CN";
        }

        InvocationInfoProxy.setLocale(localeCode);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
