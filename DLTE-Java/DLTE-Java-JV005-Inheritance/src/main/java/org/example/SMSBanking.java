package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

public class SMSBanking {
    public static void main(String[] args) {


    }

}
@Data
@AllArgsConstructor
@NoArgsConstructor

class Kyc{
    private long accNum;
    private String name;
    private double balance;
    private int upi;

    public Kyc(long accNum, String name, double balance, int upi) {
        this.accNum = accNum;
        this.name = name;
        this.balance = balance;
        this.upi = upi;
    }

    public long getAccNum() {
        return accNum;
    }

    public void setAccNum(long accNum) {
        this.accNum = accNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getUpi() {
        return upi;
    }

    public void setUpi(int upi) {
        this.upi = upi;
    }
}

class Transaction extends Kyc {
    Scanner sc = new Scanner(System.in);

    public void balanceEnquiry() {
        System.out.println("Enter the account  number");
        long accnum = sc.nextLong();
        System.out.println("Enter the Holder Name");
        String name = sc.next();
        System.out.println("Enter the UPI pin");
        int upi = sc.nextInt();
        if (upi.equals(getUpi())) {
            System.out.println("The balance is" + this.balance);
        }
    }
}

    public void recharge(){

    }

    public void bookticket(){

    }




