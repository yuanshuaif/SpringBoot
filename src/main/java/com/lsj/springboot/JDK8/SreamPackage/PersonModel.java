package com.lsj.springboot.JDK8.SreamPackage;

import lombok.*;
import lombok.Data;

/**
 * Created by 10326 on 2019/4/20.
 * @NoArgsConstructor ： 生成一个无参数的构造方法
 * @AllArgsContructor： 会生成一个包含所有变量
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PersonModel {
    private String name;
    private int age;
    private String phone;
}
