package com.zkk.test.aop.impl;

import com.zkk.test.aop.UserService;

/**
 * Created by zkk on 2018/8/25 15:14 .
 */
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("增加用户");
    }
    @Override
    public void update(int a) {
        System.out.println("修改用户");
    }
    @Override
    public void delete() {
        System.out.println("删除用户");
    }
    @Override
    public void search() {
        System.out.println("查询用户");
    }
}
