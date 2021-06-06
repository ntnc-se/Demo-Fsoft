package com.example.fsoft.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Student {

    private int id;
    private String name;
    private int age;
    private String major;
    private boolean gender;
    private String studentCode;

}
