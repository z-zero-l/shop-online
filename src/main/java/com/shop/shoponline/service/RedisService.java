package com.shop.shoponline.service;

/**
 *
 * @description: Redis服务接口
 *
 **/
public interface RedisService {
    /**
     * 添加 Redis术语中 string 类型的数据
     *
     * @param key   key
     * @param value value
     * @return boolean
     */
    boolean set(final String key, Object value);

    /**
     * 添加 Redis术语中 string 类型的数据,并设置超时
     *
     * @param key        key
     * @param value      value
     * @param expireTime 过期时间
     * @return boolean
     */
    boolean set(final String key, Object value, Long expireTime);

    /**
     * 判断 key 是否存在
     *
     * @param key key
     * @return boolean
     */
    boolean existsKey(final String key);

    /**
     * 根据Redis的key 获取值,如果出现异常则返回null
     *
     * @param key  key
     * @param type 类型
     * @param <T>  泛型
     * @return 值
     */
    <T> T getValue(final String key, Class<T> type);

    /**
     * 删除对应的value
     *
     * @param key key
     */

    void removeKey(final String key);

    /**
     * 批量删除对应的value
     *
     * @param keys keys
     */

    void remove(final String... keys);

    /**
     * 批量删除key
     *
     * @param pattern 通配
     */

    void removePattern(final String pattern);
}
