package me.readyou.springbootlearn.starter.stringhandler;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by wuxinlong on 18/5/2.
 */
@ConfigurationProperties("spring.boot.learn.string.handler")
public class StringHandlerProperties {
    private int handleType;

    public int getHandleType() {
        return handleType;
    }

    public StringHandlerProperties setHandleType(int handleType) {
        this.handleType = handleType;
        return this;
    }
}
