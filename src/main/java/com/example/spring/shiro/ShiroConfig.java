package com.example.spring.shiro;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition(){
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
//       1.配置直接放行的请求
        chainDefinition.addPathDefinition("/register.html","anon");

//        2. 需要登录后才可以访问的请求
        chainDefinition.addPathDefinition("/**","authc");


        return chainDefinition;
    }

    @Bean
    public Realm customRealm(){
       final CustomRealm customRealm = new CustomRealm();


        return customRealm;
    }

}
