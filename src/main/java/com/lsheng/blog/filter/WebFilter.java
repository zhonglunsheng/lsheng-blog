package com.lsheng.blog.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author zhonglunsheng
 * @Description
 * @create 2020-08-02 17:39
 */
@javax.servlet.annotation.WebFilter(urlPatterns = "/*", filterName = "webFilter")
public class WebFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest requeset = (HttpServletRequest) servletRequest;
        StringBuffer requestURL = requeset.getRequestURL();
        if (requestURL.toString().contains("/admin")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            servletRequest.getRequestDispatcher("/lipop/index.html").forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
