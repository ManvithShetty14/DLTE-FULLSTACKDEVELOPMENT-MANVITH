package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Scanner;

@Data


class GPay {
    Scanner sc = new Scanner(System.in);
    private int accnum;
    private double balance;
    private int upipin;
    private String name;

    public GPay(int accnum, double balance, int upipin, String name) {
        this.accnum = accnum;
        this.balance = balance;
        this.name = name;
        this.upipin = upipin;
    }


    public int getAccnum() {
        return accnum;
    }

    public void setAccnum(int accnum) {
        this.accnum = accnum;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getUpipin() {
        return upipin;
    }

    public void setUpipin(int upipin) {
        this.upipin = upipin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GPay{" +
                "accnum=" + accnum +
                ", balance=" + balance +
                ", upipin=" + upipin +
                ", name='" + name + '\'' +
                '}';
    }

    public void transferFund() {
        double amnt;
        System.out.println("Enter the amount to be transferred");
        amnt = sc.nextDouble();
        int upi;

        if (amnt <= this.balance) {
            System.out.println("Enter the UPI pin");
            upi = sc.nextInt();
            if (this.upipin == upi) {
                System.out.println("The amount " + amnt + " has been transferred successfully");
                balance -= amnt;
                System.out.println("The remaining balance is" + balance);
            } else {
                System.out.println("Incorrect UPI");
            }
        } else {
            System.out.println("Insufficient Balance");

        }
    }

    public void rechargemobile(){
        long phone;
        int ramount;
        System.out.println("Enter the mobile number");
        phone=sc.nextLong();
        System.out.println("Enter the recharge amount");
        ramount=sc.nextInt();
        int upi;
        if (ramount <= this.balance) {
            System.out.println("Enter the UPI pin");
            upi = sc.nextInt();
            if (this.upipin == upi) {
                System.out.println("Mobile Number " +phone+ " has been recharged with amount "+ramount+" successfully");
                balance -= ramount;
                System.out.println("The remaining balance is" + balance);
            } else {
                System.out.println("Incorrect UPI");
            }
        } else {
            System.out.println("Insufficient Balance");

        }

    }

    public void rechargeFasTag(){
        int ramount;

        System.out.println("Enter the FasTag recharge amount");
        ramount=sc.nextInt();
        int upi;
        if (ramount <= this.balance) {
            System.out.println("Enter the UPI pin");
            upi = sc.nextInt();
            if (this.upipin == upi) {
                System.out.println("FasTag recharged successfully");
                balance -= ramount;
                System.out.println("The remaining balance is" + balance);
            } else {
                System.out.println("Incorrect UPI");
            }
        } else {
            System.out.println("Insufficient Balance");

        }

    }

}
public class ConsoleGPay {
    public static void main(String[] args) {

        GPay obj = new GPay(2341536, 500000, 1234, "Manvith");
        obj.transferFund();
        obj.rechargemobile();
        obj.rechargeFasTag();


    }
}




