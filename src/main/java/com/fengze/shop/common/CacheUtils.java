package com.fengze.shop.common;

/**
 * 类注释
 *
 * @author zhanglingsi
 *         createTime: 2017/1/4 12:47
 */
public interface CacheUtils {

    public void put(String key, String value) ;

    public void put(String key, Object value) ;

    public <T> T get(String key, Class<T> className) ;

    public String get(String key) ;
}
