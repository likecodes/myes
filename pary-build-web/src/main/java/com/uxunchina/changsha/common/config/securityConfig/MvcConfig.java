package com.uxunchina.changsha.common.config.securityConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by leo on 2017/7/16.
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override

    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("**.html").addResourceLocations("classpath:/static/html/**.html");

        super.addResourceHandlers(registry);

    }
}
