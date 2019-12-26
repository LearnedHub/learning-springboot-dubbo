package cn.zhucongqi.springboot.dubbo.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ：Jobsz
 * @project ：learning-springboot-dubbo
 * @date ：Created in 2019/12/26 22:44
 * @description：
 * @modified By：
 * @version:
 */
@Data
public class User implements Serializable {

    private Long id;
    private String name;
    private String intro;
    private String address;
}
