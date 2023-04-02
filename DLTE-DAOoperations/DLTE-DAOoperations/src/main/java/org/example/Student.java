package org.example;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;


public class Student {
    private int reg_no;
    private String Name;
    private int serial_no;
    private String email;
    private int age;
    private ArrayList<Address> addresses =new ArrayList<>();

    @Override
    public String toString() {
        return "Student{" +
                "reg_no=" + reg_no +
                ", Name='" + Name + '\'' +
                ", serial_no=" + serial_no +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", addresses=" + addresses +
                '}';
    }

    public Student(int reg_no, String name, int serial_no, String email, int age, ArrayList<Address> addresses) {
        this.reg_no = reg_no;
        Name = name;
        this.serial_no = serial_no;
        this.email = email;
        this.age = age;
        this.addresses = addresses;
    }

    public Student() {

    }

    public ArrayList<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(ArrayList<Address> addresses) {
        this.addresses = addresses;
    }

    public int getReg_no() {
        return reg_no;
    }

    public void setReg_no(int reg_no) {
        this.reg_no = reg_no;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getSerial_no() {
        return serial_no;
    }

    public void setSerial_no(int serial_no) {
        this.serial_no = serial_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
