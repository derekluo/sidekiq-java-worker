package com.zouyyu;

import com.zouyyu.config.Config;
import com.zouyyu.utils.ConfigFactory;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


/**
 * @author YuZou
 * @date 29/03/2018
 */
public class RedisConnection {

    private static JedisPool pool;
    private static  final Config CONFIG = ConfigFactory.getConfig();

    public synchronized static JedisPool getPool(){
        if(pool == null){
          pool =  new JedisPool(new JedisPoolConfig(), CONFIG.getRedis().getRedisURI());
        }
        return  pool;
    }
}
