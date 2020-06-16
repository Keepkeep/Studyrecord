package com.studysecurity.VerifyCode.config;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.security.sasl.AuthenticationException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义二维码验证器
 */
@Component
public class VerifyCodeFilter extends GenericFilterBean {
    private String defaultFilterProcessUrl = "/doLogin";

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
       HttpServletRequest request = (HttpServletRequest)req;
       HttpServletResponse response  = (HttpServletResponse) resp;
       if("post".equalsIgnoreCase(((HttpServletRequest) req).getMethod()) && defaultFilterProcessUrl.equals(request.getServletPath())){
            //验证码
           String requestCaptcha  = request.getParameter("code");
           String genCaptcha  = (String)request.getSession().getAttribute("index_code");
           if(StringUtils.isEmpty(requestCaptcha)){
               throw  new AuthenticationServiceException("验证码不能为空！");
           }
           if(!genCaptcha.toLowerCase().equals(requestCaptcha.toLowerCase())){
               throw  new AuthenticationServiceException("验证码错误！");
           }
       }

        filterChain.doFilter(request,response);
    }
}
