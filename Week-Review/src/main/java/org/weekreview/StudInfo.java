package org.weekreview;


import java.io.*;
import java.util.*;
import java.util.Scanner;

public class StudInfo {
    private static Object detail;
    ArrayList<Student> studentList = new ArrayList<>();
    File file = new File("studentrecord.txt");


        public void addDetails (ArrayList<Student> studentList) throws IOException {
            String name, email, address;
            Integer regno;

            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            Scanner sc = new Scanner(System.in);
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

        public ArrayList<Student> display () throws IOException, ClassNotFoundException {

            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            return (ArrayList<Student>) ois.readObject();
        }

}

