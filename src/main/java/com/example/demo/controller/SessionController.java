package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by ds on 2018-04-09.
 */

@Controller
public class SessionController {

    @GetMapping("")
    public String test(HttpSession httpSession) {
        httpSession.setAttribute("test", "HelloWorld");
        return httpSession.getId();
    }
}
