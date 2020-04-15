package com.platform.demo.io;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SampleObject {

    private String name;
    private int age;


    public SampleObject(String name, int age){
        this.name = name;
        this.age = age;
    }
}
