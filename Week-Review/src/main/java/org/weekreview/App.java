package org.weekreview;

/**
 * Hello world!
 *
 */
import java.io.*;
import java.util.*;
public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        StudInfo studInfo=new StudInfo();
        Scanner sc=new Scanner(System.in);
        StudentInterface studentInter=new StudentInterface();
        boolean flag=true;

        do {
            System.out.println("Enter the choice");
            System.out.println("1) Add Student Details");
            System.out.println("2) Display");
            Integer ch = sc.nextInt();

            switch (ch)
            {
                case 1:
                    studInfo.addDetails();
                    break;
                case 2:  studInfo.display();
                    break;
                case 3:
                    System.out.println("Thank you");
                    flag=false;
            }
        }while(flag);
    }
    }




