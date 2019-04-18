package com.boot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Redis配置
 * Properties属性的使用
 */
@Configuration
public class RedisConfigure {

    @Value("${redis.host}")
    private String host;
    @Value("${redis.port}")
    private String port;
    @Value("${redis.db}")
    private String db;
    @Value("${redis.timeout}")
    private String timeout;

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public String getDb() {
        return db;
    }

    public String getTimeout() {
        return timeout;
    }
}
