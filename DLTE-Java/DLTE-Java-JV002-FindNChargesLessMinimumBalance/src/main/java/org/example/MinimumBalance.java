package org.example;

import java.util.Arrays;

public class MinimumBalance {
    Double[] charge(Double[] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]>1000 && arr[i]<5000 ){
                arr[i] -= (arr[i] * 3)/100;
            }
            else if(arr[i]>=5000 && arr[i]<10000){
                arr[i] -= (arr[i] * 5)/100;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        Double[] balances = {3000.0,8000.0,5000.0,11000.0,20000.0,2500.0,2100.0,9000.0,20000.0,1000.0,3300.0,3700.0,9800.0,29000.0,3000.0,30000.0,12000.0,6600.0,9100.0,8000.0};
        MinimumBalance minbal = new MinimumBalance();
        System.out.println(Arrays.toString(minbal.charge(balances)));
    }
}