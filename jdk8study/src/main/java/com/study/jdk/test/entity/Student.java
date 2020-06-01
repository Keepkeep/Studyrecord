package com.study.jdk.test.entity;

import java.io.Serializable;


@Data
public class Student implements Serializable {
    private  Long  id ;
    private  String name;
    private int age;

}
