package com.ryz2593.common.redis;

/**
 * @author ryz2593
 * @date 2019/4/11
 * @desc redis 操作接口
 */
public interface RedisService {
    boolean set(String key, String value);
    String get(String key);
    boolean expire(String key, long time);
}
