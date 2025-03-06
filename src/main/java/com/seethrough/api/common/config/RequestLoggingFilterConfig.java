package com.seethrough.api.common.config;

import com.seethrough.api.common.filter.CustomRequestLoggingFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RequestLoggingFilterConfig {

    @Bean
    public FilterRegistrationBean<CustomRequestLoggingFilter> requestLoggingFilter() {
        FilterRegistrationBean<CustomRequestLoggingFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new CustomRequestLoggingFilter());
        registrationBean.setOrder(1);  // 실행 순서 설정
        return registrationBean;
    }
}
