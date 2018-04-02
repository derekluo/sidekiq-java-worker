package com.zouyyu.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.zouyyu.WorkerException;
import com.zouyyu.config.Config;
import com.zouyyu.config.RedisConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

/**
 * @author YuZou
 * @date 31/03/2018
 */
public class ConfigFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigFactory.class);

    private static final String SIDEKIQ_YML = "sidekiq.yml";
    private static Config config;
    private static final ObjectMapper MAPPER = new ObjectMapper(new YAMLFactory());

    public static synchronized Config getConfig() {
        if (config == null) {
            try {
                URL sidekiqURL = ConfigFactory.class.getClassLoader().getResource(SIDEKIQ_YML);
                if (sidekiqURL == null) {
                    throw new WorkerException("缺少配置文件 -- sidekiq.yml");
                }
                config = MAPPER.readValue(new File(sidekiqURL.getFile()), Config.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return config;
    }
}
