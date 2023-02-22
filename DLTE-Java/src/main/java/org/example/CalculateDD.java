package org.example;

public class CalculateDD {
    public static void main(String[] args) {
        Integer amount=500000 , duration=3 ;
        Double maturity=0.0 , interest=6.4 , temp=0.0;
        temp=amount*interest/100;
        maturity = amount + temp;
        while(duration>1){
            maturity=maturity+temp;
            duration--;
        }

        System.out.println(maturity);


    }
}
