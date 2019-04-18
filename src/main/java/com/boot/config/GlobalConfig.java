package com.boot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalConfig {

    public static final String PIC_URL_PATH = "E:\\test";


    @Value("${app.name}")
    private String appName;

    @Value("${app.description}")
    private String appDescription;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppDescription() {
        return appDescription;
    }

    public void setAppDescription(String appDescription) {
        this.appDescription = appDescription;
    }
}
