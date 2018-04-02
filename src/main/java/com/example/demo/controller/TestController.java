package com.example.demo.controller;

import com.example.demo.domain.mysql.USER;
import com.example.demo.service.LoginService;
import com.example.demo.service.SessionService;
import com.example.demo.utils.ContextUtils;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by ds on 2018-03-26.
 */

@Controller
public class TestController {

    @Autowired
    LoginService loginService;

    @Autowired
    SessionService sessionService;

    /*@GetMapping("")
    public String test(HttpSession httpSession) {
        httpSession.setAttribute("test", "HelloWorld");
        return httpSession.getId();
    }*/

    @GetMapping(value = {"", "login"})
    public String login() {
        return "login";
    }

    @PostMapping(value = "login-processing")
    public String loginProcessing(HttpServletRequest request, HttpServletResponse response, String id, String pw) {
        if(loginService.login(id, pw)) {
            response.addCookie(sessionService.createCookie());
            return "redirect:main";
        }
        else return "redirect:login";
    }

    @GetMapping("main")
    public String main(Model model) {
        model.addAttribute("user", (USER) ContextUtils.getAttrFromSession("login"));
        return "main";
    }

    @GetMapping("logout")
    public String logout() {
        loginService.logout();
        return "redirect:login";
    }
}
