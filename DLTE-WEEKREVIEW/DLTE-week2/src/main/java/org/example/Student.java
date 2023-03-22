package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor

public class Student implements Serializable {
    private Integer reg_no,age;
    private String name;
    private String  email,address;

    public Student(Integer reg_no,  String name, Integer age, String email, String address) {
        this.reg_no = reg_no;
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;

    }

    @Override
    public String toString() {
        return "Details{" +
                "reg_no=" + reg_no +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
