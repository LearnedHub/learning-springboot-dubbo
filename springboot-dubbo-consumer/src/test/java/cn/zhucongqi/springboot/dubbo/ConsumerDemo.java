package cn.zhucongqi.springboot.dubbo;

import cn.zhucongqi.springboot.dubbo.controller.AppController;
import cn.zhucongqi.springboot.dubbo.domain.User;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author ：Jobsz
 * @project ：learning-springboot-dubbo
 * @date ：Created in 2019/12/26 23:22
 * @description：
 * @modified By：
 * @version:
 */
public class ConsumerDemo {

    @Configuration
    @EnableDubbo(scanBasePackages = "cn.zhucongqi.springboot.dubbo.controller")
    @PropertySource("classpath:application.properties")
    @ComponentScan("cn.zhucongqi.springboot.dubbo.controller")
    static public class ConsumerConfiguration {

    }
    AnnotationConfigApplicationContext context;
    {
        context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();
    }

    @Test
    public void test() {
        AppController appController = context.getBean(AppController.class);

        User user = appController.user(12L);
        System.out.println(user);
    }
}
