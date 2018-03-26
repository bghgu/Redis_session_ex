package com.example.demo.service;

import com.example.demo.domain.mysql.USER;

import javax.servlet.http.Cookie;

/**
 * Created by ds on 2018-03-26.
 */
public interface SessionService {
    void setSession(final USER user);
    Cookie createCookie();
}
