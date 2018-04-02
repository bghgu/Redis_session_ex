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
        HttpSession httpSession = ContextUtils.getSession(true);
        httpSession.setAttribute("login", user);
    }

    @Override
    public void deleteSession() {
        HttpSession httpSession = ContextUtils.getSession(true);
        //로그인 객체 세션에서 삭제
        httpSession.removeAttribute("login");
        //세션 무효화, 세션을 삭제하는 것이 아님!!!
        httpSession.invalidate();
    }

    @Override
    public Cookie createCookie() {
        HttpSession httpSession = ContextUtils.getSession(false);
        return new Cookie("loginCookie", httpSession.getId());
    }
}
