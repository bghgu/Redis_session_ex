package com.example.demo.serviceImpl;

import com.example.demo.domain.mysql.USER;
import com.example.demo.repository.CookieRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.LoginService;
import com.example.demo.service.SessionService;
import com.example.demo.utils.ContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import java.util.Optional;

/**
 * Created by ds on 2018-03-26.
 */

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SessionService sessionService;

    @Autowired
    CookieRepository cookieRepository;

    @Override
    public boolean login(final String id, final String pw) {
        Optional<USER> user = userRepository.findByIdAndPassword(Integer.parseInt(id), pw);
        if(!user.isPresent()) return false;
        else {
            //현재 저장된 세션에 user 객체를 저장
            sessionService.setSession(user.get());
            USER temp = user.get();
            temp.setSessionId(sessionService.getSessionId());
            //DB에 유저 객체가 저장된 세션 id를 저장
            userRepository.save(temp);
            return true;
        }
    }

    @Override
    public void logout() {
        Cookie loginCookie = WebUtils.getCookie( ContextUtils.getRequest(), "loginCookie");
        if ( loginCookie != null ){
            loginCookie.setPath("/");
            loginCookie.setMaxAge(0);
            ContextUtils.getResponse().addCookie(loginCookie);
        }
        sessionService.deleteSession();
    }

    @Override
    public USER findBySessionId(String id) {
        return userRepository.findBySessionId(id);
    }

}
