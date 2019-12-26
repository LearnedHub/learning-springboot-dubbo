package cn.zhucongqi.springboot.dubbo.services;

import cn.zhucongqi.springboot.dubbo.api.IUser;
import cn.zhucongqi.springboot.dubbo.domain.User;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author ：Jobsz
 * @project ：learning-springboot-dubbo
 * @date ：Created in 2019/12/26 22:56
 * @description：
 * @modified By：
 * @version:
 */
@Service
public class UserImpl implements IUser {

    @Override
    public User getUserById(Long id) {

        User user = new User();
        user.setId(id);
        user.setName("Jobsz");
        user.setIntro("Developer");
        user.setAddress("China Beijing");
        return user;
    }
}
