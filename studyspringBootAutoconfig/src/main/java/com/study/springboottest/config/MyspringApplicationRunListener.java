package com.study.springboottest.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;

import java.io.IOException;
import java.util.Properties;

public class MyspringApplicationRunListener implements SpringApplicationRunListener {


    private final SpringApplication application;
    private final String[] args;


    public MyspringApplicationRunListener(SpringApplication application, String[] args) {
        this.application = application;
        this.args = args;
    }


    public void starting() {
        System.out.println("---------->stating");
    }

    public void environmentPrepared(ConfigurableEnvironment environment) {


        //读取配置文件
        Properties  properties = new Properties();
        try {
            //读取配置文件
            properties.load(this.getClass().getResourceAsStream("/my.properties"));
            //读取名称
            PropertiesPropertySource propertySource = new PropertiesPropertySource("my", properties);
            //将资源添加到项目中
            MutablePropertySources propertySources = environment.getPropertySources();
            //通过api接口将配置文件读到spring boot 项目中
            propertySources.addLast(propertySource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void contextPrepared(ConfigurableApplicationContext context) {

    }

    public void contextLoaded(ConfigurableApplicationContext context) {

    }

    public void started(ConfigurableApplicationContext context) {

    }

    public void running(ConfigurableApplicationContext context) {

    }

    public void failed(ConfigurableApplicationContext context, Throwable exception) {

    }
}
