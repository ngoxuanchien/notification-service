package com.hdbank.config;

import com.hdbank.common.annotation.Application;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration(proxyBeanMethods = false)
@ComponentScan(
        basePackages = {"com.hdbank"},
        includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Application.class)
)
public class BeanConfig {
}
