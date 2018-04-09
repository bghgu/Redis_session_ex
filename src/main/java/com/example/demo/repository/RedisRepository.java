package com.example.demo.repository;

import com.example.demo.domain.redis.RedisUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by ds on 2018-04-09.
 */

public interface RedisRepository extends CrudRepository<RedisUser, String> {
    List<RedisUser> findByName(final String name);
}
