package com.example.demo.serviceImpl;

import com.example.demo.domain.mysql.USER;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.Optional;

/**
 * Created by ds on 2018-03-26.
 */

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean login(String id, String pw) {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession httpSession = attr.getRequest().getSession();
        Optional<USER> user = userRepository.findByIdAndPassword(Integer.parseInt(id), pw);
        if(!user.isPresent()) return false;
        else {
            httpSession.setAttribute("login", user.get());
            return true;
        }
    }
}
