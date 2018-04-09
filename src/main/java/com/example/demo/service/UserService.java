package com.example.demo.service;

import com.example.demo.domain.redis.RedisUser;

import java.util.List;

/**
 * Created by ds on 2018-04-09.
 */
public interface UserService {
    RedisUser findById(final String id);
    List<RedisUser> findByName(final String name);
    void saveUser(final RedisUser user);
    void deleteUser(final String id);
}
