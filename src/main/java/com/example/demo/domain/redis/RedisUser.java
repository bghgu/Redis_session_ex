package com.example.demo.domain.redis;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by ds on 2018-04-09.
 */

@Data
//레디스 테이블 키 값
@RedisHash("user")
public class RedisUser implements Serializable {

    private static final long serialVersionUID = -287881979735272273L;

    //객체의 키 값
    @Id
    private String id;
    //세컨더리 인덱스
    @Indexed
    private String name;
    private String password;
}
