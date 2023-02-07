package com.caster.springcloud.userservice.service.impl;

import com.caster.springcloud.userservice.pojo.User;
import com.caster.springcloud.userservice.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private List<User> userList;

    @Override
    public void insert(User user) {
        userList.add(user);
    }

    @Override
    public User getUser(Long id) {
        List<User> list = userList.stream().filter(userItem -> userItem.getId().equals(id)).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(list))
            return list.get(0);
        return null;
    }

    @Override
    public void update(User user) {
        userList.stream().filter(userItem -> userItem.getId().equals(user.getId())).forEach(userItem ->{
            userItem.setPassword(user.getPassword());
            userItem.setUsername(user.getUsername());
        });
    }

    @Override
    public void delete(Long id) {
        User user=getUser(id);
        if(user!=null)
            userList.remove(user);
    }

    @Override
    public User getByUsername(String username) {
        List<User> list=userList.stream().filter(userItem ->userItem.getUsername().equals(username)).collect(Collectors.toList());
        if(!CollectionUtils.isEmpty(list))
            return list.get(0);
        return null;
    }

    @Override
    public List<User> listUsersByIds(List<Long> ids) {
        return userList.stream().filter(userItem -> ids.contains(userItem.getId())).collect(Collectors.toList());
    }

    @PostConstruct
    public void initData(){
        userList=new ArrayList<>();
        userList.add(new User(1L, "caster", "123456"));
        userList.add(new User(2L, "andy", "123456"));
        userList.add(new User(3L, "mark", "123456"));
    }
}
