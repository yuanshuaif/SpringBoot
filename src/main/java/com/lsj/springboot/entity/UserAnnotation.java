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
/*@Getter
@Setter
@ToString*/
public class UserAnnotation implements Serializable{
    @NotNull
    private String name;
    private int age;
    @NotNull
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
