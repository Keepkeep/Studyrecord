package com.studysecurity.config;

import com.studysecurity.VerifyCode.config.VerifyCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 注入verifycodeFilter 验证码过滤器
     */
    @Autowired
    VerifyCodeFilter verifyCodeFilter;

    /**
     *密码验证器
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder passwordEncoder = NoOpPasswordEncoder.getInstance();
        return passwordEncoder;
    }

    /**
     * 认证
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("huhu").roles("admin").password("123")
                .and()
                .withUser("lili").roles("user").password("123");
    }

    /**
     *忽略拦截
     * 如果某一个请求地址不需要拦截的话，有两种方式实现
     * 设置该地址匿名访问
     *
     * 直接过滤掉该地址，即该地址不走 Spring Security 过滤器链
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/vercode/get","/code.html");

    }

    /**
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //配置过滤器
        http.addFilterBefore(verifyCodeFilter, UsernamePasswordAuthenticationFilter.class);
        http.authorizeRequests() //开启登录配置
        .antMatchers("/hello").hasRole("admin") //表示hello 这个接口需要具备amdin角色
        .anyRequest().authenticated()//表示 剩余的其他接口，登录之后就能访问
        .and()
        .formLogin()
        //定义 登录页页面，未登录时，直接跳转这个页面
        .loginPage("/login_p.html")
        //登录处理接口 doLogin
        .loginProcessingUrl("/doLogin")
        //定义登录时，用户名的 key，默认为 username
        .usernameParameter("uname")
        //定义登录时，用户密码的 key，默认为 password
        .passwordParameter("password")
        .successHandler(new AuthenticationSuccessHandler() {
            public void onAuthenticationSuccess(HttpServletRequest rep, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                resp.setContentType("application/json;charset=utf-8");
                PrintWriter out = resp.getWriter();
                out.write("success");
                out.flush();
            }
        })
        .failureHandler(new AuthenticationFailureHandler() {
            public void onAuthenticationFailure(HttpServletRequest rep, HttpServletResponse resp, AuthenticationException e) throws IOException, ServletException {
                resp.setContentType("application/json;charset=utf-8");
                PrintWriter out = resp.getWriter();
                out.write("fail");
                out.flush();
            }
        })
        .permitAll()
         .and()
         .logout()
         .logoutUrl("/logout")
         .logoutRequestMatcher(new AntPathRequestMatcher("/logout","POST"))
         .logoutSuccessUrl("/code.html")
         .deleteCookies()
         .clearAuthentication(true)
         .invalidateHttpSession(true)
         .permitAll()
         .and()
          .httpBasic()
          .and()
           .csrf().disable();
    }



}
