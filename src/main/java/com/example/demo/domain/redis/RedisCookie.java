package com.example.demo.domain.redis;

import lombok.Data;
import org.hibernate.annotations.Index;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by ds on 2018-04-09.
 */

@Data
@RedisHash("cookie")
public class RedisCookie implements Serializable {
    private static final long serialVersionUID = -8286921941650916974L;

    @Id
    private String sessionId;

    @Indexed
    private int id;
}
