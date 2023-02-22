package org.example;
import java.util.*;
public class LoanCalculator {
    public static void main(String[] args) {
       Integer  year;
       Double rate , emi=0.0 ,loan, pay ;
       Scanner sc=new Scanner(System.in);

        System.out.println("Enter the loan amount");
        loan=sc.nextDouble();

        System.out.println("Enter the tenure");
        year=sc.nextInt();

        System.out.println("Enter the interest rate");
        rate=sc.nextDouble();

        pay=loan+(loan*rate*year)/100;
        emi=pay/(year*12);

        System.out.println("EMI per month is"+emi);

        Double total_interest=pay-loan;

        System.out.println("The total interest is"+total_interest);

        System.out.println("The total repayment is"+pay);

    }

}
