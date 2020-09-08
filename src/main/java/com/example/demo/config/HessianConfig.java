package com.example.demo.config;

import com.example.demo.service.CommentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;




@Configuration
public class HessianConfig {

    @Bean
    public CommentService commentService() {
        HessianProxyFactoryBean invoker = new HessianProxyFactoryBean();
        invoker.setServiceUrl("http://localhost:8080/interconnect/commentService");
        invoker.setServiceInterface(CommentService.class);
        invoker.setHessian2(true);
        invoker.setUsername("interconnect_user");
        invoker.setPassword("interconnect_password");
        invoker.afterPropertiesSet();
        return (CommentService) invoker.getObject();
    }
}
