package com.zouyyu.utils;

import com.zouyyu.RedisConnection;
import com.zouyyu.WorkerException;
import com.zouyyu.config.Config;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author YuZou
 * @date 31/03/2018
 */
public class ConfigFactoryTest {

    @Ignore
    @Test(expected = WorkerException.class)
    public void testGetConfigException(){
        ConfigFactory.getConfig();
    }

    @Test
    public  void testGetConfigThreadSafe() throws InterruptedException {
        final CountDownLatch begin = new CountDownLatch(1);
        final ExecutorService exec = Executors.newFixedThreadPool(10);

        List<Config> configs = new ArrayList<>();

        for (int i =0; i< 10; i++){
            int tmp = i;
            Runnable runnable = () -> {
                configs.add(ConfigFactory.getConfig());
                System.out.println("第" + tmp + "执行");
            };
            exec.submit(runnable);
        }
        System.out.println("开始执行");
        begin.countDown();
        exec.awaitTermination(1000, TimeUnit.MILLISECONDS);

        Assert.assertEquals(configs.get(0), configs.get(1));
    }

    @Test
    public  void testConvertToConfig(){
        Config config = ConfigFactory.getConfig();
        Assert.assertEquals("example", config.getQueueName());
        Assert.assertNotNull(config.getRedis());
        Assert.assertEquals(new Integer(1), config.getRedis().getDb());
    }
}
