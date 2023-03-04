package org.example;

import org.omg.CORBA.TRANSACTION_MODE;

import java.util.Date;
import java.util.Hashtable;
import java.util.LinkedList;

public class TransactionCollection {
    public static void main(String[] args) {
        Transaction trans1=new Transaction(101,"NFT","Savings",30000.0,"24/02/2001");
        Transaction trans2=new Transaction(102,"Online","Current",50000.0,"21/09/2012");
        Transaction trans3=new Transaction(108,"Card","Current",70000.0,"09/12/2019");
        Transaction trans4=new Transaction(105,"NFT","Savings",15000.0,"31/03/2016");

        LinkedList<Transaction> transaction=
    }
}
class Transaction{
    Integer transid;
    String type;
    String mode;
    Double amnt;
    String date;

    public Transaction(Integer transid,String type,String mode,Double amnt,String date){
        this.transid=transid;
        this.amnt=amnt;
        this.type=type;
        this.mode=mode;
        this.date=date;
    }

}