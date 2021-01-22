package com.lsj.springboot.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by 10326 on 2019/4/13.
 * lombok的使用
 */
@Getter
@Setter
@ToString
public class UserAnnotation implements Serializable{
    @NotNull
    private String name;
    private int age;
    @NotNull
    private String phone;
}
