package com.example.demo.repository;

import com.example.demo.domain.redis.RedisCookie;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ds on 2018-04-09.
 */
public interface CookieRepository extends CrudRepository<RedisCookie, String> {
}
