package cn.zhucongqi.springboot.dubbo.controller;

import cn.zhucongqi.springboot.dubbo.api.IHelloApi;
import cn.zhucongqi.springboot.dubbo.api.IUser;
import cn.zhucongqi.springboot.dubbo.domain.User;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：Jobsz
 * @project ：learning-springboot-dubbo
 * @date ：Created in 2019/12/26 21:57
 * @description：
 * @modified By：
 * @version:
 */
@RestController
public class AppController {

    @Reference
    IHelloApi IHelloApi;

    @Reference
    IUser iUser;

    @GetMapping("/app/{data}")
    public String hello(@PathVariable("data") String data) {
        return IHelloApi.hello(data);
    }

    @GetMapping("/user/{id}")
    public User user(@PathVariable("id") Long id) {
        return iUser.getUserById(id);
    }
}
