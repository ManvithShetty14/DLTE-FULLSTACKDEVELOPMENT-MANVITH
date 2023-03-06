package org.example;


import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.sort;
//credit card class implements from interface class(creditMethods)
public class CreditCard implements CreditMethods{

    Scanner scanner = new Scanner(System.in);
    Double[] cbills = new Double[5];

    public static void main (String[]args){

        CreditCard creditCard = new CreditCard();
        //Read the Inputs from user
        System.out.println("Enter the bills of New card : ");

        for (int index = 0; index < creditCard.cbills.length; index++) {
            creditCard.cbills[index] = creditCard.scanner.nextDouble();

        }
        System.out.println("Credit card bills are Registered : "+Arrays.toString(creditCard.cbills));
        Integer input;
        do{
        System.out.println("Select the Operation to be performed :\n 1 - New card Entry \n 2 - Update the bill of the particular index\n 3 - Add 18% GST on all the Credit card bills\n 4 - Add 3% Gst on the bills more than 30000 \n 5 - list the credit card bills  ");
        input = creditCard.scanner.nextInt();
        switch (input) {
            case 1 : creditCard.newCardEntry();
                break;
            case 2:
                creditCard.updateBillOfIndex();
                break;
            case 3:
                creditCard.addGst();
                break;
            case 4:
                creditCard.searchAndAdd();
                break;
            case 5:
                creditCard.sortAndList();
                break;
            default:
                System.out.println("Invalid input");
                break;
        }

    }while (input != 5);
    }
    // All the interface class abstract methods are implemented here:
    @Override
    public void newCardEntry () {
        System.out.println("Enter the new credit card  bill");
        Double newbill= scanner.nextDouble();
        cbills= Arrays.copyOf( cbills,cbills.length +1);
        cbills[cbills.length-1] = newbill;
        System.out.println("New Credit card bill added");
        System.out.println("Credit card bills : "+Arrays.toString(cbills));
    }

    @Override
    public void updateBillOfIndex () {
        System.out.println("Enter the position in bill  ");
        Integer pos=scanner.nextInt();
        cbills[pos-1] = 0.0;
        System.out.println("The credit card bill Updated Successfully!!");
        System.out.println("Credit card bills : "+Arrays.toString(cbills));
    }

    @Override
    public void addGst () {
        for (int index = 0; index < cbills.length; index++) {
            cbills[index] += cbills[index] * 0.18;
        }
        System.out.println("Credit card bills(includeing GST for each bill): " + Arrays.toString(cbills));
    }

    @Override
    public void searchAndAdd () {
        for (int index = 0; index < cbills.length; index++) {
            if (cbills[index] >= 30000)
                cbills[index] += cbills[index] * 0.03;
        }
        System.out.println("Added 3% GST for all the bills greater than 30000");
        System.out.println("Credit card bills : "+Arrays.toString(cbills));
    }

    @Override
    public void sortAndList () {
        sort(cbills);
        System.out.println("The Sorted Credit Card bills: " + Arrays.toString(cbills));
    }
}
//interface class(CreditMethods)
interface CreditMethods {
    void newCardEntry();

    void updateBillOfIndex();

    void addGst();

    void searchAndAdd();

    void sortAndList();
}