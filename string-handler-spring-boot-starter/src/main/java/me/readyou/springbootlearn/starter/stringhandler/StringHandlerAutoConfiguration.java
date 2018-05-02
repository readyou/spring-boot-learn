package me.readyou.springbootlearn.starter.stringhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wuxinlong on 18/5/2.
 */
@Configuration
@ConditionalOnClass(StringHandlerService.class)
@EnableConfigurationProperties(StringHandlerProperties.class)
public class StringHandlerAutoConfiguration {
    @Autowired
    private StringHandlerProperties stringHandlerProperties;

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "spring.boot.learn.string.handler", value = "enabled", havingValue = "true")
    StringHandlerService exampleService() {
        return new StringHandlerService(stringHandlerProperties.getHandleType());
    }
}
