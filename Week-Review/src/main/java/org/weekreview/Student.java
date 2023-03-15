package org.weekreview;

import lombok.Data;
import java.util.*;
import java.io.*;
public class Student implements Serializable {
    Scanner sc = new Scanner(System.in);
    private int regno;
    private String name;
    private int age;
    private String email;
    private String address;

    public Student(int regno, String name, int age, String email, String address) {
        this.regno = regno;
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sc=" + sc +
                ", regno=" + regno +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public int getRegno() {
        return regno;
    }

    public void setRegno(int regno) {
        this.regno = regno;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;


    }
}
