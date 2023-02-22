package org.example;

import java.util.Scanner;
public class BalanceArray {
    public static void main(String[] args) {
        Double[] balance = new Double[20];
        Scanner sc = new Scanner(System.in);
        Double charge;

        System.out.println("Enter the balance");
        for (int index = 0; index < 21; index++) {
            balance[index] = sc.nextDouble();
        }

            calculate(balance);

    }
public static int calculate(Double[] arr) {
    for (int i = 0; i < 21; i++) {
        if (arr[i] >= 5000 && arr[i] <= 9999) {
            Double charge = (arr[i] * 3) / 100;
            System.out.println("the charge is" + charge);

        } else if (arr[i] >= 1000 && arr[i] <= 4999) {
            Double charge = (arr[i] * 5) / 100;
            System.out.println("the charge is" + charge);
        }
    }
    return charge;

}





}

