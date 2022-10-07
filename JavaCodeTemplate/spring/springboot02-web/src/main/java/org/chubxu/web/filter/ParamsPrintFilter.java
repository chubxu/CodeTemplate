package org.chubxu.web.filter;

import com.alibaba.fastjson.JSON;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * @ClassName ParamsPrintFilter
 * @Description 过滤器，在每次请求前打印请求参数
 * @Author chubxu
 * @Date 2021/1/9 21:46
 * @Version 1.0
 **/
public class ParamsPrintFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
        System.out.println(JSON.toJSONString(parameterMap));
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
