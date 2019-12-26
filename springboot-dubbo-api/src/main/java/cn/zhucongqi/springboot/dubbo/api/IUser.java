package cn.zhucongqi.springboot.dubbo.api;

import cn.zhucongqi.springboot.dubbo.domain.User;

/**
 * @author ：Jobsz
 * @project ：learning-springboot-dubbo
 * @date ：Created in 2019/12/26 22:44
 * @description：
 * @modified By：
 * @version:
 */
public interface IUser {

    User getUserById(Long id);

}
