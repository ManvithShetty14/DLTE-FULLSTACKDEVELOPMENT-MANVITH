package org.example;

import java.util.Arrays;
import java.util.Scanner;
//User defined Exception
class OutstandingException extends Exception{
    public OutstandingException(String err){
        System.out.println(err);
    }
}

public class ExceptionInAddingNewTrackLoan {
    //Method to add the bill amount
       void addBalance(Integer[] balance,Integer amnt,Integer index) throws OutstandingException {
        if (index >= balance.length) {
            throw new OutstandingException("Outstanding balance: Replaced with the minimum bill");
        } else {
            balance[index] = amnt;
        }
    }
    //Method to replace the minimum bill with the new bill
       void replaceMinimum(Integer[] balances,Integer amount){
        Integer index = 0;
        Integer min = balances[index];
        for (int i = 1; i < balances.length; i++){
            if (balances[i] <= min){
                min = balances[i];
                index = i;
            }
        }
        balances[index] = amount;
    }
    //The main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer balance[] = new Integer[10];
        Integer amount;
        ExceptionInAddingNewTrackLoan trackloan=new ExceptionInAddingNewTrackLoan();
        for (int i=0;i<12;i++){
            System.out.println("Enter the outstanding bill:");
            amount = sc.nextInt();
            //try block
            try {

                trackloan.addBalance(balance,amount,i);
                System.out.println(Arrays.toString(balance));

            }
            //catch block
            catch (OutstandingException e){
                System.out.println("Exception occured: " + e);
                trackloan.replaceMinimum(balance,amount);
                System.out.println(Arrays.toString(balance));
            }
        }
    }
}
