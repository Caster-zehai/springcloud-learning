package com.caster.springcloud.nacosuserservice.service;

import com.caster.springcloud.nacosuserservice.pojo.User;

import java.util.List;

public interface UserService {
    void insert(User user);

    User getUser(Long id);

    void update(User user);

    void delete(Long id);

    User getByUsername(String username);

    List<User> listUsersByIds(List<Long> ids);

}
