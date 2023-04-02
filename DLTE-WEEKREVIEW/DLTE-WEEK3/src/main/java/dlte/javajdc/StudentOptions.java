package dlte.javajdc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import oracle.jdbc.OracleDriver;

import java.sql.*;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class StudentOptions implements StudentInterface {
    private Driver driver;
    private PreparedStatement preparedStatement;
    private String query;
    private ResultSet resultSet;
    private Connection connection;

    public void jdbcConnection() throws SQLException {
        driver = new OracleDriver();
        DriverManager.registerDriver(driver);
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","250601");
        System.out.println("Successfully connected to Oracle DB");
        preparedStatement=connection.prepareStatement("alter session set current_schema=MANVITH");
        preparedStatement.executeQuery();

    }


    @Override
    public void insertRecords(Student student,Address address) throws SQLException {
        query = "insert into address values(address_id_seq.NEXTVAL,?,?,?,?)";
        preparedStatement  = connection.prepareStatement(query);
        preparedStatement.setInt(1,address.getDoor());
        preparedStatement.setString(2,address.getStreet());
        preparedStatement.setString(3,address.getCity());
        preparedStatement.setInt(4,address.getPin());
        int y = preparedStatement.executeUpdate();

        query="insert into student values(?,?,?,?,address_id_seq.CURRVAL)";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,student.getReg_no());
        preparedStatement.setString(2,student.getName());
        preparedStatement.setInt(3,student.getAge());
        preparedStatement.setString(4, student.getEmail());
        preparedStatement.executeQuery();
        int x = preparedStatement.executeUpdate();

        if(x>0 && y>0) {
            System.out.println("Student records inserted successfully!!");
        }
        else {
            System.out.println("Student records not inserted");
        }
    }

    @Override
    public void display() throws SQLException {
        query = "select * from student, address where student.address_id = address.address_id";
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            System.out.println(resultSet.getInt("Reg_No")+" "+resultSet.getString("name")+" "+resultSet.getInt("age")+" "+resultSet.getString("email")+" "+" "+resultSet.getInt("Door_no")+" "+resultSet.getString("street")+" "+resultSet.getString("City")+" "+resultSet.getInt("Pincode"));
        }
    }


    @Override
    public  String delete(int  reg_no) throws SQLException {
        query = "delete from student where reg_no = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,reg_no);
        if(preparedStatement.executeUpdate()>0)
            System.out.println("Record deleted!!");
        else
            System.out.println("Record cannot delete!");
        return "deleted";
    }
}