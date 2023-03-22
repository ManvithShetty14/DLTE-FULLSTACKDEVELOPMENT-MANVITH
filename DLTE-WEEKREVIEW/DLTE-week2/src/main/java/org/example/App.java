package org.example;

import java.io.*;
import java.util.Scanner;

public class App{

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        StudentOption studentOption = new StudentOption();
        boolean choice=true;
        while (choice) {
            System.out.println("Enter your choice");
            System.out.println("1.Insert Record\n2.View Record\n3.Exit\n");
            switch (sc.nextInt()) {
                case 1:
                    studentOption.addDetails();
                    break;
                case 2:
                    studentOption.viewDetails();
                    break;
                case 3:
                      choice=false;
                      System.out.println("Thank You");
                      break;
                default:
                    System.out.println("Invalid choice");

            }
        }
    }
}