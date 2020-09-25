package com.tu.mvctest.common;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.Set;

@Component
public class RedisTool {

    private static Jedis jedis;

    //创建单例模式，获取jedis 饿汉模式
    public Jedis getJedis0(){

        if(null == jedis){
            jedis = new Jedis("192.168.36.128",6379);
        }

        return jedis;
    }

    //双安全检查模式
    public Jedis getJedis1(){

        if(null == jedis){
            synchronized(this){
                if(null == jedis){
                    jedis = new Jedis("192.168.36.128",6379);
                }
            };
        }
        return jedis;
    }




    public void redisMain(){

//        Jedis jedis = new Jedis("192.168.36.128",6379);
        getJedis1();
        jedis.set(String.valueOf(2),"男");
        jedis.set(String.valueOf(3),"女");
        jedis.set(String.valueOf(4),"女");

        System.out.println(jedis.get("2"));


    }

    public static void main(String[] args) {
        RedisTool tool = new RedisTool();

        tool.redisMain();
    }

}
