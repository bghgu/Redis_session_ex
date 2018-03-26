package com.example.demo.serviceImpl;

import com.example.demo.domain.mysql.USER;
import com.example.demo.service.SessionService;
import com.example.demo.utils.ContextUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

/**
 * Created by ds on 2018-03-26.
 */

@Service
public class SessionServiceImpl implements SessionService {

    @Override
    public void setSession(USER user) {
        HttpSession httpSession = ContextUtils.getSession(false);
        httpSession.setAttribute("login", user);
    }

    @Override
    public Cookie createCookie() {
        HttpSession httpSession = ContextUtils.getSession(false);
        return new Cookie("loginCookie", httpSession.getId());
    }
}
