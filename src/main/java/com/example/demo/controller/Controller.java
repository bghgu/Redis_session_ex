package com.example.demo.controller;

import com.example.demo.domain.redis.RedisUser;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ds on 2018-04-09.
 */

@RestController
public class Controller {

    @Autowired
    UserService userService;

    /**
     * 학번으로 조회
     * @param id
     * @return
     */
    @GetMapping("id/{id}")
    public RedisUser getUser(@PathVariable("id") final String id) {
        System.out.println(id);
        return userService.findById(id);
    }

    /**
     * 이름으로 조회
     * @param name
     * @return
     */
    @GetMapping("name/{name}")
    public List<RedisUser> getUserList(@PathVariable("name") final String name) {
        System.out.println(name);
        return userService.findByName(name);
    }

    /**
     * 사람 저장
     * @param user
     */
    @PutMapping("3")
    public void saveUser(final @RequestBody RedisUser user) {
        userService.saveUser(user);
    }

    /**
     * 학번으로 삭제
     * @param id
     */
    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable("id") final String id) {
        userService.deleteUser(id);
    }
}
