package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by ds on 2018-03-26.
 */

@RestController
public class TestController {

    @GetMapping("")
    public String test(HttpSession httpSession) {
        httpSession.setAttribute("test", "HelloWorld");
        return httpSession.getId();
    }
}
