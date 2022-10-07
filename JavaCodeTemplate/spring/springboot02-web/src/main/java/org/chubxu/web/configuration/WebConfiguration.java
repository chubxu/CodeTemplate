package org.chubxu.web.configuration;

import org.chubxu.web.filter.ParamsPrintFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName WebConfiguration
 * @Description Web相关的 配置类
 * @Author chubxu
 * @Date 2021/1/9 21:31
 * @Version 1.0
 **/
@Configuration
public class WebConfiguration {

    @Bean
    public FilterRegistrationBean filterRegistration() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new ParamsPrintFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("paramsPrintFilter");
        registrationBean.setOrder(1);
        return registrationBean;
    }


}
