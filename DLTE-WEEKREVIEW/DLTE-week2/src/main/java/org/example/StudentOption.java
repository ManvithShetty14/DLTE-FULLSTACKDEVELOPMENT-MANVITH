package org.example;

import java.io.*;
import java.util.Scanner;

public class StudentOption implements StudentInterface,Serializable{
    File file = new File("studentrecord.txt");

    public void addDetails() throws IOException {
        Scanner sc = new Scanner(System.in);
        Integer reg_no, age;
        String name, email, address;
        System.out.println("Enter the registration number");
        reg_no = sc.nextInt();
        System.out.println("Enter the name");
        name = sc.next();
        System.out.println("Enter the age");
        age = sc.nextInt();
        System.out.println("Enter the email");
        email = sc.next();
        System.out.println("Enter the address");
        address = sc.next();
        Student student = new Student(reg_no, name, age, email, address);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(student.toString());
        objectOutputStream.close();
        fileOutputStream.close();
    }

    public void viewDetails() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        System.out.println(objectInputStream.readObject());
        objectInputStream.close();
        fileInputStream.close();
    }

}
