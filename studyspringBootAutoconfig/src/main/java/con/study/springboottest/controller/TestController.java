package con.study.springboottest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.Redis;

@RestController
public class TestController {

    //引入自定的start的配置
    @Autowired
    private Redis redis;
    @RequestMapping("/test")
    public Object test(){
        return redis;
    }
}
