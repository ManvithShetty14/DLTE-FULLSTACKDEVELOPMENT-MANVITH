package org.example;

import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        DAOoperations daOoperations = new DAOoperations();
        //List<Student> list = new ArrayList<>();
        //list = daOoperations.fetchStudent();
       // List<Address> list = new ArrayList<>();
        //list = daOoperations.fetchAddress(103);
        Address address1=new Address("322-1","Mangalore","Mangalore",34657);
        ArrayList<Address> address=new ArrayList<>();
       Address address2=new Address("344-1","kengeri","Bangalore",571447);
        address.add(address1);
        address.add(address2);
        Student student=new Student(110,"Kirtan",22,"Kirtan@123",21,address);
        System.out.println(daOoperations.insertDb(student));


    }
}
