package com.cssnj.ywgl.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Auther: duq
 * @Date: 2019/1/12 21:25
 */
@Component
@PropertySource("classpath:core.properties")
@ConfigurationProperties(prefix = "web")
public class WebProperites {

    private String ignore;

    public String getIgnore() {
        return ignore;
    }

    public void setIgnore(String ignore) {
        this.ignore = ignore;
    }

}
