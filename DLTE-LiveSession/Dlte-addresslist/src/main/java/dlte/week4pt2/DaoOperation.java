package dlte.week4pt2;

import oracle.jdbc.driver.OracleDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoOperation {
    Driver driver;
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    public DaoOperation() throws SQLException {
        driver=new OracleDriver();
        DriverManager.registerDriver(driver);
        connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "250601");
        preparedStatement=connection.prepareStatement("alter session set current_schema=MANVITH");
        preparedStatement.executeQuery();
    }

    public Student insertion(Student student) throws SQLException {
        String query="insert into student_e values(?,?,?,?)";
        preparedStatement=connection.prepareStatement(query);
        preparedStatement.setInt(1, student.getReg_no() );
        preparedStatement.setString(2,student.getName());
        preparedStatement.setInt(3, student.getAge());
        preparedStatement.setString(4, student.getEmail());
        preparedStatement.executeUpdate();

        for(Address address : student.getAddresses()){
            String query1 = "insert into address_e values(address_seq.NEXTVAL,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(query1);
            preparedStatement.setInt(1,address.getDoor_no());
            preparedStatement.setString(2,address.getStreet());
            preparedStatement.setString(3, address.getCity());
            preparedStatement.setInt(4, address.getPincode());
            preparedStatement.setString(5, address.getType());
            preparedStatement.executeUpdate();

            String query2="insert into address_mapper values(?,address_seq.CURRVAL)";
            preparedStatement=connection.prepareStatement(query2);
            preparedStatement.setInt(1,student.getReg_no());
            preparedStatement.executeUpdate();
        }
        return student;
    }

    public List<Student> fetchStudent() throws SQLException {
       String query="select * from student_e";
       preparedStatement=connection.prepareStatement(query);
       resultSet=preparedStatement.executeQuery();
       List<Student> info= new ArrayList<>();
       while (resultSet.next()){
           Student student=new Student();
           student.setReg_no(resultSet.getInt("reg_no"));
           student.setName(resultSet.getString("name"));
           student.setAge(resultSet.getInt("age"));
           student.setEmail(resultSet.getString("email"));
           info.add(student);
       }
       return info;
    }

//    public List<Address> fetchAddress(){
//        String query="select * from "
//    }

}