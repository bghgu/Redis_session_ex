package com.example.demo.domain.redis;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by ds on 2018-03-26.
 */
@Data
@RedisHash("login")
public class Login implements Serializable{
    private static final long serialVersionUID = -5951640711090390748L;


}
