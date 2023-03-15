package org.weekreview;


import java.io.*;
import java.util.*;
import java.util.Scanner;

public class StudInfo{
    private static Object detail;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc=new Scanner(System.in);
        boolean flag=true;

        do {
            System.out.println("Enter the choice");
            System.out.println("1) Add Student Details");
            System.out.println("2) Display");
            Integer ch = sc.nextInt();

            switch (ch)
            {
                case 1: addDetails();
                display();
                break;
                case 2:  display();
                break;
            }
        }while(flag);
    }

    public static void addDetails() throws IOException, ClassNotFoundException {
        String  name,email,address;
        Integer regno;
        File file = new  File("studentrecord.txt");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Student Reg_no");
        regno = sc.nextInt();
        System.out.println("Enter Student Name");
        name = sc.next();
        System.out.println("Enter Student age");
        int age = sc.nextInt();
        System.out.println("Enter Student Email_Id");
        email = sc.next();
        System.out.println("Enter the Student Address");
        address = sc.next();
        oos.writeObject(new Student(regno, name, age, email, address));
    }

    public static void display() throws IOException, ClassNotFoundException {
            File file1 = new  File("studentrecord.txt");
            FileInputStream fis = new FileInputStream(file1);
            ObjectInputStream ois = new ObjectInputStream(fis);
            System.out.println(ois.readObject());
    }
}

