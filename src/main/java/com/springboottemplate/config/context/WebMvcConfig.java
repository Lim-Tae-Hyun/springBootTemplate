package com.springboottemplate.config.context;

import com.springboottemplate.base.filter.TemplateFilter;
import com.springboottemplate.base.interceptor.TemplateInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@EnableWebMvc
@ComponentScan(basePackages = "com.springboottemplate")
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private TemplateInterceptor templateInterceptor;

    @Bean
    public MappingJackson2JsonView jsonViewResolver() {
        MappingJackson2JsonView viewResolver = new MappingJackson2JsonView();
        viewResolver.setPrefixJson(false);
        viewResolver.setContentType("application/json; charset=UTF-8");
        return viewResolver;
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false)
                .favorParameter(true)
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_ATOM_XML)
                .mediaType("json", MediaType.APPLICATION_JSON)
                .mediaType("html", MediaType.TEXT_HTML);
    }

    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("/config/message/msg");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(templateInterceptor)
                .addPathPatterns("/**");
    }

    @Bean
    public FilterRegistrationBean getFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new TemplateFilter());
        return registrationBean;
    }

    /*
    @Bean
    public ViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setContentType("text/html; charset=UTF-8");
        return viewResolver;
    }*/

}
