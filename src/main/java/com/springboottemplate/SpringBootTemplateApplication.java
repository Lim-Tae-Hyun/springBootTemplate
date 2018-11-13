package com.springboottemplate;

import com.springboottemplate.config.context.SecurityConfig;
import com.springboottemplate.config.context.WebMvcConfig;
import com.springboottemplate.config.mybatis.MybatisConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@Configuration
@Import({
        WebMvcConfig.class
        , SecurityConfig.class
        , MybatisConfig.class
})
@PropertySource({
        "classpath:/properties/${spring.profile.active:local}.properties"
})
public class SpringBootTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTemplateApplication.class, args);
    }
}
