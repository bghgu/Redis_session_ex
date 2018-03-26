package com.example.demo.domain.redis;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;

/**
 * Created by ds on 2018-03-26.
 */
@Data
@RedisHash("login")
public class Login {
}
