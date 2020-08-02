package com.lsheng.blog.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lsheng.blog.common.ResponseCode;
import com.lsheng.blog.common.ResponseInfo;
import com.lsheng.blog.util.JwtUtil;
import org.apache.commons.lang3.StringUtils;

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
        ObjectMapper jsonMapper = new ObjectMapper();
        ServletOutputStream outputStream = servletResponse.getOutputStream();
        HttpServletRequest requeset = (HttpServletRequest) servletRequest;
        StringBuffer requestURL = requeset.getRequestURL();
        if (requestURL.toString().contains("/admin")) {
            String jwtToken = requeset.getHeader("Authorization");
            if (StringUtils.isBlank(jwtToken) || JwtUtil.checkJWT(jwtToken) == null) {
                servletResponse.setContentType("application/json;charset=utf-8");
                ResponseInfo result = ResponseInfo.createResponseInfoByEnum(ResponseCode.LOGIN_ERROR, null);
                byte[] resByte = jsonMapper.writeValueAsString(result).getBytes();
                outputStream.write(resByte);
                outputStream.flush();
                outputStream.close();
            }else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } else {
            servletRequest.getRequestDispatcher("/lipop/index.html").forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
