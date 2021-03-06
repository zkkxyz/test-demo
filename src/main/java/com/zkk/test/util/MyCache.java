package com.zkk.test.util;

import com.zkk.test.domain.entity.Account;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangkaikai on 2018/2/22 022 14:57 .
 */
public class MyCache implements Cache {
    private String name;
    private Map<String,Account> store = new HashMap<String,Account> ();;

    public MyCache() {
    }

    public MyCache(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object getNativeCache() {
        return store;
    }

    @Override
    public ValueWrapper get(Object key) {
        Cache.ValueWrapper result = null;
        Account thevalue = store.get(key);
        if(thevalue!=null) {
            thevalue.setPassword("from mycache:"+name);
            result = new SimpleValueWrapper (thevalue);
        }
        return result;
    }

    @Override
    public <T> T get(Object key, Class<T> type) {
        return null;
    }

    @Override
    public ValueWrapper putIfAbsent(Object key, Object value) {
        return null;
    }

    @Override
    public void put(Object key, Object value) {
        Account thevalue = (Account)value;
        store.put((String)key, thevalue);
    }

    @Override
    public void evict(Object key) {
    }

    @Override
    public void clear() {
    }
}
