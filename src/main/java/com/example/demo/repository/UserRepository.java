package com.example.demo.repository;

import com.example.demo.domain.USER;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


/**
 * Created by ds on 2018-03-26.
 */
public interface UserRepository extends CrudRepository<USER, Integer>{
    Optional<USER> findByIdAndPassword(final int id, final String pw);
    USER findBySessionId(final String sessionId);
}
