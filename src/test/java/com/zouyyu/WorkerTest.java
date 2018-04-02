package com.zouyyu;

import com.zouyyu.config.RedisConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author YuZou
 * @date 31/03/2018
 */
public class WorkerTest {

    SNWorker worker = new SNWorker();

    @Before
    public void setUp(){
        worker = new SNWorker();
        JedisPool jedisPool = RedisConnection.getPool();
        try(Jedis jedis = jedisPool.getResource()) {
            jedis.lpush("queue:example", "{\"class\":\"ActiveJob::QueueAdapters::SidekiqAdapter::JobWrapper\",\"wrapped\":\"ExampleJob\",\"queue\":\"example\",\"args\":[{\"job_class\":\"ExampleJob\",\"job_id\":\"be9cf6fe-7fea-469c-8cfc-8a3b6eb32f72\",\"provider_job_id\":null,\"queue_name\":\"example\",\"priority\":null,\"arguments\":[12313],\"executions\":0,\"locale\":\"zh-CN\"}],\"retry\":true,\"jid\":\"f9aebd1cc05257296976b417\",\"created_at\":1522307754.1833699,\"enqueued_at\":1522307754.183428}");
        }
    }

    @Test
    public void testFetchOriginJob(){
        Assert.assertEquals(2, worker.fetchOriginJob().size());
    }

    @Test
    public void testFetchOne(){
        Assert.assertNotNull(worker.fetchOne());
    }

    @Ignore
    @Test
    public void testStart(){
        worker.start();
    }

}
