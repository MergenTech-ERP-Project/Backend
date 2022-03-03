/*
package com.mergen.vtys.vtysdatabaseap.config;

import com.mergen.vtys.vtysdatabaseap.Filters.RequestResponseLoggers;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FiltersConfig {

    @Bean
    FilterRegistrationBean<RequestResponseLoggers> createLoggers (RequestResponseLoggers requestResponseLoggers)
    {
        FilterRegistrationBean<RequestResponseLoggers> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(requestResponseLoggers);

        registrationBean.addUrlPatterns(  // Yazılan path'lere göre logging yapılmasını sağlar.

        );
        return registrationBean;
    }
}

    */
