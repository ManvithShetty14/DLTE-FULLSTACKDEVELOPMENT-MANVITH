package dlte.daooperate;

import dlte.daooperate.Address;
import dlte.daooperate.Operation;
import dlte.daooperate.Student;
import oracle.jdbc.driver.OracleDriver;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoOperate implements Operation {
    ResourceBundle resourceBundle=ResourceBundle.getBundle("student");
    private PreparedStatement preparedStatement;
    Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


    @Override
    public int insertDb(Student student) {
        Connection con=makeConnection();
            try {
                preparedStatement = con.prepareStatement("insert into student_table values(?,?,usn_seqn.NEXTVAL,?,?)");
                preparedStatement.setInt(1,student.getRegno());
                preparedStatement.setString(2, student.getName());
                preparedStatement.setString(3, student.getEmail());
                preparedStatement.setInt(4, student.getAge());
                preparedStatement.executeUpdate();
                for (Address address : student.getAddresses()) {
                    preparedStatement = con.prepareStatement("insert into address_table values(add_id_seq.NEXTVAL,usn_seqn.CURRVAL,?,?,?,?)");
                    preparedStatement.setString(1, address.getDoor());
                    preparedStatement.setString(2, address.getStreet());
                    preparedStatement.setString(3, address.getCity());
                    preparedStatement.setInt(4, address.getPincode());
                    preparedStatement.executeUpdate();
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }

            return 0;
    }


    @Override
    public List<Student> fetch() throws SQLException {
        Connection con = makeConnection();
        List<Student> students = new ArrayList<>();
        try{
            preparedStatement = con.prepareStatement("select * from student_table");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                List<Address> addresses = fetchAddress(resultSet.getInt("regno"));
                Student student = new Student(resultSet.getInt("regno"),resultSet.getString("name"),resultSet.getString("email"),resultSet.getInt("age"),addresses);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public List<Address> fetchAddress(int reg_no) throws SQLException {
        Connection con = makeConnection();
        List<Address> addresses = new ArrayList<>();

        try{
            preparedStatement = con.prepareStatement("select * from student_table join address_table on address_table.usn = student_table.usn and regno=?");
            preparedStatement.setInt(1,reg_no);
            ResultSet addressSet = preparedStatement.executeQuery();
            while (addressSet.next()){
                addresses.add(new Address(addressSet.getString("door_no"),addressSet.getString("street"),addressSet.getString("city"),addressSet.getInt("pincode")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addresses;
    }

    @Override
    public String deleteDb(int reg_no){
        Connection con=makeConnection();
        try{
// preparedStatement=connection.prepareStatement("select Register_No from Student_table where reg_no=? ");
            preparedStatement=con.prepareStatement("delete from Student_table where regno=?");
            preparedStatement.setInt(1,reg_no);
            int value= preparedStatement.executeUpdate();
            if(value==0){
                throw new IdNotFoundException("Student doesn't exist");
            }

        }
        catch (IdNotFoundException id){
            return resourceBundle.getString("dbdelete_exception");
        }

        catch (SQLException e) {
            e.printStackTrace();
        }


// private boolean idExists(int reg_no) {
// return true;
// }
        logger.log(Level.INFO,resourceBundle.getString("dbdelete"));
        return "deleted";

    }

    @Override
    public Connection makeConnection() {
        Connection connection = null;
        try {
            Driver driver=new OracleDriver();
            DriverManager.registerDriver(driver);
            connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","250601");
            preparedStatement = connection.prepareStatement("alter session set current_schema=MANVITH");
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

