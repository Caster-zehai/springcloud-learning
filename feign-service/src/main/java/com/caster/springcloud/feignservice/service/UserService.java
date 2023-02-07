package com.caster.springcloud.feignservice.service;

import com.caster.springcloud.feignservice.pojo.*;
import com.caster.springcloud.feignservice.service.impl.UserFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "user-service/user", fallback = UserFallbackService.class)
public interface UserService {
    @PostMapping("/insert")
    public Result insert(@RequestBody User user);

    @GetMapping("/{id}")
    public Result<User> getUser(@PathVariable Long id);

    @GetMapping("/listUsersByIds")
    public Result<List<User>> listUsersByIds(@RequestParam List<Long> ids);

    @GetMapping("/getByUsername")
    public Result<User> getByUsername(@RequestParam String username);

    @PostMapping("/update")
    public Result update(@RequestBody User user) ;

    @PostMapping("/delete/{id}")
    public Result delete(@PathVariable Long id);
}
