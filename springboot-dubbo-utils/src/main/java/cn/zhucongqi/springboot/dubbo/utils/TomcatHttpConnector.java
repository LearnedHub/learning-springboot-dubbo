package cn.zhucongqi.springboot.dubbo.utils;

import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：Jobsz
 * @project ：learning-spring-boot-mybatis
 * @date ：Created in 2019/12/19 23:31
 * @description：
 * @modified By：
 * @version:
 */
@Configuration
public class TomcatHttpConnector {

    @Value("${server.http.port}")
    private Integer httpPort;

    @Value("${server.port}")
    private Integer httpsPort;

    @Bean
    public TomcatServletWebServerFactory tomcatServletWebServerFactory() {
        TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory();
        tomcatServletWebServerFactory.addAdditionalTomcatConnectors(this.httpConnector());
        tomcatServletWebServerFactory.addContextCustomizers(this.securityCustomizer());
        return tomcatServletWebServerFactory;
    }

    private Connector httpConnector() {
        Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
        connector.setScheme("http");
        connector.setPort(httpPort);
        connector.setSecure(false);
        connector.setRedirectPort(httpsPort);
        return connector;
    }

    private TomcatContextCustomizer securityCustomizer() {
        return context -> {
            SecurityConstraint securityConstraint = new SecurityConstraint();
            securityConstraint.setUserConstraint("CONFIDENTIAL");
            SecurityCollection collection = new SecurityCollection();
            collection.addPattern("/*");
            securityConstraint.addCollection(collection);
            context.addConstraint(securityConstraint);
        };
    }
}
