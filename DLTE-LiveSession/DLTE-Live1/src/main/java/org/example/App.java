package org.example;

import java.sql.SQLException;
import java.sql.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {

        System.out.println( "Hello World!" );
        DaoOperation daoOperation=new DaoOperation();
//        Loan loan=new Loan(103,"Hero","Car",200000,"02-FEB-2022");
//        System.out.println(daoOperation.insert(loan));
        System.out.println(daoOperation.fetch(2001));
    }
}
