package cn.zhucongqi.springboot.dubbo.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ：Jobsz
 * @project ：learing-spt
 * @date ：Created in 2019/12/19 18:06
 * @description：
 * @modified By：
 * @version:
 */
@Component
public class JacksonUtil {

    private final ObjectMapper objectMapper;

    @Autowired
    public JacksonUtil(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @SneakyThrows
    public <T> T toObject(String json, Class<?> clazz) {
        return (T)this.objectMapper.readValue(json, clazz);
    }

    @SneakyThrows
    public String toJson(Object object) {
        return this.objectMapper.writeValueAsString(object);
    }
}
