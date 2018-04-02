package com.zouyyu;

import org.junit.Assert;
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
public class RedisConnectionTest {

    @Test
    public void testPoolThreadSafe() throws InterruptedException {
        final CountDownLatch begin = new CountDownLatch(1);
        final ExecutorService exec = Executors.newFixedThreadPool(10);

        List<JedisPool> jedisPools = new ArrayList<>();

        for (int i =0; i< 10; i++){
            int tmp = i;
            Runnable runnable = () -> {
                jedisPools.add(RedisConnection.getPool());
                System.out.println("第" + tmp + "执行");
            };
            exec.submit(runnable);
        }
        System.out.println("开始执行");
        begin.countDown();
        exec.awaitTermination(1000, TimeUnit.MILLISECONDS);

        Assert.assertEquals(jedisPools.get(0), jedisPools.get(1));
    }
}
