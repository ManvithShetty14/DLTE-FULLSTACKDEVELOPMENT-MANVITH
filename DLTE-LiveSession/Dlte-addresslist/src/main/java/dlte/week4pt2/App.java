package dlte.week4pt2;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        System.out.println( "Hello World!" );
        DaoOperation daoOperation=new DaoOperation();
//        Student student=new Student(901,"asdcv",21,"asdfc@123");
//        Address address=new Address(123,213,"asdf","poasd",23123,"permanent");
//        Address address2=new Address(123,213,"asdf","poasd",23123,"communicaion");
//        System.out.println(daoOperation.insertion(student));

       System.out.println(daoOperation.fetchStudent());


    }




}
