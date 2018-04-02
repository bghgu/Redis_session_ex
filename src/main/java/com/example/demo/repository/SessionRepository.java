package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import javax.servlet.http.HttpSession;

/**
 * Created by ds on 2018-04-02.
 */
public interface SessionRepository extends CrudRepository<HttpSession, String> {

}
