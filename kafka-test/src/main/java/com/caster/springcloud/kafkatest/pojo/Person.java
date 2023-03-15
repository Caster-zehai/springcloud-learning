package com.caster.springcloud.kafkatest.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Person {
    private Integer age;
    private Boolean success;
    private Date birthday;
}
