package cn.zhucongqi.springboot.dubbo.services;

import cn.zhucongqi.springboot.dubbo.api.IHelloApi;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author ：Jobsz
 * @project ：learning-springboot-dubbo
 * @date ：Created in 2019/12/26 20:54
 * @description：
 * @modified By：
 * @version:
 */
@Service
public class HelloApiImpl implements IHelloApi {

    @Override
    public String hello(String data) {
        return "Call hello content => " + data;
    }
}
