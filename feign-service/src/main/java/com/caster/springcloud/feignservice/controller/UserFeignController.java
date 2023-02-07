package com.caster.springcloud.feignservice.controller;

import com.caster.springcloud.feignservice.pojo.Result;
import com.caster.springcloud.feignservice.pojo.User;
import com.caster.springcloud.feignservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserFeignController {

    @Autowired
    private UserService userService;//此处warning，可以不用管

    @PostMapping("/insert")
    public Result insert(@RequestBody User user) {
        return userService.insert(user);
    }

    @GetMapping("/{id}")
    public Result<User> getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/listUsersByIds")
    public Result<List<User>> listUsersByIds(@RequestParam List<Long> ids) {
        return userService.listUsersByIds(ids);
    }

    @GetMapping("/getByUsername")
    public Result<User> getByUsername(@RequestParam String username) {
        return userService.getByUsername(username);
    }

    @PostMapping("/update")
    public Result update(@RequestBody User user) {
        return userService.update(user);
    }

    @PostMapping("/delete/{id}")
    public Result delete(@PathVariable Long id) {
        return userService.delete(id);
    }

}
