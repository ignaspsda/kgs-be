package com.league.kgs.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {
    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {}
    @Override
    public void doFilter(
            final ServletRequest request, final ServletResponse response, final FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpResponse.setHeader(
                "Access-Control-Allow-Methods", "POST, GET, PUT, PATCH, OPTIONS, DELETE");
        httpResponse.setHeader("Access-Control-Max-Age", "3600");
        httpResponse.setHeader(
                "Access-Control-Allow-Headers",
                "Origin, X-Requested-With, X-Forwarded-Proto, Content-Type, Accept, Authorization");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        if ("OPTIONS".equalsIgnoreCase(httpRequest.getMethod())) {
            httpResponse.setStatus(HttpServletResponse.SC_OK);
        } else {
            chain.doFilter(request, response);
        }
    }
    @Override
    public void destroy() {}

}
