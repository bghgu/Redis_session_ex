package com.example.demo.service;

import com.example.demo.domain.USER;

/**
 * Created by ds on 2018-03-26.
 */
public interface LoginService {
    boolean login(final String id, final String pw);
    void logout();
    USER findBySessionId(final String id);
}
