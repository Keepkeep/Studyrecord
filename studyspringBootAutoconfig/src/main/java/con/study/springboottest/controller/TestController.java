package con.study.springboottest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.Redis;

@RestController
public class TestController {

    //引入自定的start的配置
    @Autowired
    private Redis redis;
    @Autowired
    private Environment environment;
    @RequestMapping("/test")
    public Object test(){
        String property = environment.getProperty("mytest.name");
        System.out.println("测试属性"+property);
        return redis;
    }


}
