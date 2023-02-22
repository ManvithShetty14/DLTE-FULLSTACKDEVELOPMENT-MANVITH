package org.example;

import java.util.*;

public class PersonalLoanCalculator {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Integer amount;
        Integer tenure;
        Double emi,totalamount, repay, interest, rate;

        //User input values
        System.out.println("Enter the amount");
        amount=sc.nextInt();

        System.out.println("Enter the tenure");
        tenure=sc.nextInt();

        System.out.println("Enter the rate of interest");
        rate=sc.nextDouble();

        tenure=tenure*12; //convert year into month
        rate=rate/(12*100);

        //formula to calculate emi
        emi=(amount*rate*Math.pow(1+rate,tenure))/(Math.pow(1+rate,tenure)-1);

        totalamount=emi*tenure;
        repay=amount+totalamount;
        System.out.println("The monthly EMI is"+emi);
        System.out.println("The total interest paid is"+totalamount);
        System.out.println("The total repayment is"+repay);
    }
}
