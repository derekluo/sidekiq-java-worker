package com.zouyyu.config;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;

/**
 * @author YuZou
 * @date 30/03/2018
 */
public class RedisConfig {

    private static final String DEFAULT_URL = "redis://localhost:6379/0";
    private URI redisURI = URI.create(DEFAULT_URL);
    private String host = "localhost";
    private Integer port = 6379;
    private Integer db = 0;

    public RedisConfig(){}

    @JsonProperty("SIDEKIQ_REDIS_URI")
    public URI getRedisURI() {
        return redisURI;
    }

    public String getHost() {
        return redisURI.getHost();
    }

    public Integer getPort() {
        return redisURI.getPort();
    }

    public Integer getDb() {
        String path = redisURI.getPath();
        return Integer.parseInt(path.split("/")[1]);
    }

    @Override
    public String toString() {
        return "RedisConfigFactory{" +
            "redisURI=" + redisURI +
            ", host='" + host + '\'' +
            ", port=" + port +
            ", db=" + db +
            '}';
    }
}
