package com.aryanlanghanoja.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

@WebFilter("/test/*")
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("From Filter Init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("From doFilter Before Call " + (new Date().toString()));
        HttpServletRequest req = (HttpServletRequest)servletRequest ;

        if(req.getRemoteAddr().equals("192.168.117.172")) {
            filterChain.doFilter(servletRequest , servletResponse);
        }

        else {
            System.out.println("You Are Not Authorized");
        }
//        System.out.println(servletRequest.getRemoteAddr());
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("From dofilter After  call"+(new Date().toString()));
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}

//package com.allysoftsolutions.filtertest;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import java.io.IOException;
//import java.util.Date;
//@WebFilter("/test/filter_first")
//public class MyFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//        System.out.println("from filter init");
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("from dofilter before call"+(new Date().toString()));
//        filterChain.doFilter(servletRequest,servletResponse);
//        System.out.println("from dofilter after  call"+(new Date().toString()));
//    }
//
//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//    }
//}
