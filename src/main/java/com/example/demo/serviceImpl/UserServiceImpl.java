package com.example.demo.serviceImpl;

import com.example.demo.domain.redis.RedisUser;
import com.example.demo.repository.RedisRepository;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by ds on 2018-04-09.
 */

/**
 * 다형성 - 버전 관리, 라이브러리
 * 서비스 별로 테스트 버전
 * 계층 분리
 */

/**
 * DAO - mapper를 쓸지, jpa를 쓸지 모르기 때문에
 */


@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RedisRepository redisRepository;

    @Override
    public RedisUser findById(final String id) {
        Optional<RedisUser> redisUser = redisRepository.findById(id);
        if(!redisUser.isPresent()) return null;
        else {
            return redisUser.get();
        }
    }

    @Override
    public List<RedisUser> findByName(final String name) {
        List<RedisUser> list = redisRepository.findByName(name);
        return list;
    }

    @Override
    public void saveUser(final RedisUser user) {
        redisRepository.save(user);
    }

    @Override
    public void deleteUser(final String id) {
        redisRepository.deleteById(id);
    }
}
