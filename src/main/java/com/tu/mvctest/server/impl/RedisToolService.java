package com.tu.mvctest.server.impl;

import com.tu.mvctest.common.RedisTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
@Service
public class RedisToolService {

    @Autowired
    public RedisTool redisTool;
    public String setValue(String key, String val){

        Jedis jedis = redisTool.getJedis1();

        return jedis.set(key, val);
    }

    public String getValue(String key){

        Jedis jedis = redisTool.getJedis1();

        return jedis.get(key);
    }


}
