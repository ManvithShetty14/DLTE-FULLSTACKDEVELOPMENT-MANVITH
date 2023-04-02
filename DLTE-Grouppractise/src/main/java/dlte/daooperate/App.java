package dlte.daooperate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        DaoOperate daoOperate=new DaoOperate();
//        List<Address> address=new ArrayList<>();
//        Address address1=new Address("1007","SJC","Banglore",576009);
//        Address address2=new Address("1008","SMNB","Manglore",576078);
//        address.add(address1);
//        address.add(address2);
////        System.out.println(daoOperate.fetch());
//        Student student=new Student(002,"gaurav","asdf@12",21,address);
//        System.out.println(daoOperate.insertDb(student));

        daoOperate.deleteDb(002);

    }
}
