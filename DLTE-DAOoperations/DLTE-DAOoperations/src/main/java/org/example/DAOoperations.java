package org.example;

import oracle.jdbc.driver.OracleDriver;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOoperations implements Operations {
    private Connection connection;
    private PreparedStatement preparedStatement;
    Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


    @Override
    public int insertDb(Student student) {
        int x=makeConnection();
        if(x==1){
            try {
                preparedStatement = connection.prepareStatement("insert into student_table values(?,?,usn_seqn.NEXTVAL,?,?)");
              preparedStatement.setInt(1,student.getReg_no());
                preparedStatement.setString(2, student.getName());
                preparedStatement.setString(3, student.getEmail());
                preparedStatement.setInt(4, student.getAge());
                preparedStatement.executeUpdate();
                for (Address address : student.getAddresses()) {
                    preparedStatement = connection.prepareStatement("insert into address_table values(add_id_seq.NEXTVAL,usn_seqn.CURRVAL,?,?,?,?)");
                    preparedStatement.setString(1, address.getDoor());
                    preparedStatement.setString(2, address.getStreet());
                    preparedStatement.setString(3, address.getCity());
                    preparedStatement.setInt(4, address.getPincode());
                    preparedStatement.executeUpdate();

                }


            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return 0;
    }


    @Override
    public List<Student> fetchStudent() {
        int y=makeConnection();
        List<Student> list = new ArrayList<>();
        if (y==1){
            try {
                preparedStatement=connection.prepareStatement("select * from student_");
                preparedStatement.executeQuery();
                ResultSet resultset=preparedStatement.executeQuery();


                while(resultset.next()){
                    Student student = new Student();
                    student.setReg_no(resultset.getInt("reg_no"));
                    student.setName(resultset.getString("name"));
                    student.setSerial_no(resultset.getInt("serial_no"));
                    student.setEmail(resultset.getString("email"));
                    student.setAge(resultset.getInt("age"));
                    logger.info("hello");
                    list.add(student);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return list;
    }

    @Override
    public List<Address> fetchAddress(int reg_no) {
        int z=makeConnection();
        List<Address> list=new ArrayList<>();
        if(z==1){
            try {
                preparedStatement=connection.prepareStatement("select * from address_new join student_new on serial_no=student_id and reg_no=?");
                preparedStatement.setInt(1,reg_no);
                preparedStatement.executeQuery();
                ResultSet resultSet=preparedStatement.executeQuery();


                while(resultSet.next()){
                    Address address=new Address();
                    address.setAddress_id(resultSet.getInt("address_id"));
                    address.setDoor(resultSet.getString("door"));
                    address.setStreet(resultSet.getString("street"));
                    address.setCity(resultSet.getString("city"));
                    address.setPincode(resultSet.getInt("pincode"));
                    address.setStudent_id(resultSet.getInt("student_id"));
                    logger.info("hello");
                    list.add(address);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public String deleteDb(int reg_no) {
        int z=makeConnection();
        try {
            preparedStatement=connection.prepareStatement("delete from student_new where reg_no=?");
            preparedStatement.setInt(1,reg_no);
            preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "deleted";
    }

    @Override
    public int makeConnection() {
        try {
                Driver driver=new OracleDriver();
                DriverManager.registerDriver(driver);
                connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Acharya1439");
                preparedStatement = connection.prepareStatement("alter session set current_schema=\"KIRTAN U ACHARYA\"");
                preparedStatement.executeQuery();
        } catch (SQLException e) {
                e.printStackTrace();
            }
        return 1;
    }
}
