package com.example.demo.serviceImpl;

import com.example.demo.domain.mysql.USER;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.LoginService;
import com.example.demo.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
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

    @Override
    public boolean login(final String id, final String pw) {
        Optional<USER> user = userRepository.findByIdAndPassword(Integer.parseInt(id), pw);
        if(!user.isPresent()) return false;
        else {
            sessionService.setSession(user.get());
            return true;
        }
    }

}
