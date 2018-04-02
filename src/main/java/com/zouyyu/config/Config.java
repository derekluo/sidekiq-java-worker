package com.zouyyu.config;

import com.fasterxml.jackson.annotation.JsonAlias;

/**
 * @author YuZou
 * @date 31/03/2018
 */
public class Config {

    private String queueName;
    private RedisConfig redis;

    @JsonAlias({ "queueName", "queue_name", "queue-name" })
    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public RedisConfig getRedis() {
        return redis;
    }

    public void setRedis(RedisConfig redis) {
        this.redis = redis;
    }
}
