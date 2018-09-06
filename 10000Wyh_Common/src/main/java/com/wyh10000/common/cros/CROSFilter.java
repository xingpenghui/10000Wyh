package com.wyh10000.common.cros;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *@Author feri
 *@Date Created in 2018/9/5 15:04
 * 跨域资源共享
 */
public class CROSFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        System.out.println("CROS---拦截");
        //response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Origin",request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Methods","GET,POST,PUT,DELETE");
        response.setHeader("Access-Control-Max-Age","2000");
        response.setHeader("Access-Control-Allow-Headers","Origin,X-Requested-with,Content-Type,Accept");
        response.setHeader("Access-Control-Allow-Credentials","true");
        filterChain.doFilter(servletRequest,response);
    }

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void destroy() {

    }
}
