//package dlte.javaeeweek;
//
//import com.sun.org.apache.xpath.internal.operations.Or;
//import oracle.jdbc.driver.OracleDriver;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOExceptInteger Register_number= (Integer) request.getAttribute("register");ion;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@WebServlet(name = "FetchServlet")
//public class FetchServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        PreparedStatement preparedStatement;
//
//        try {
//            Driver driver=new OracleDriver();
//            DriverManager.registerDriver(driver);
//            Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","250601");
//            preparedStatement=connection.prepareStatement("alter session set current_schema=MANVITH");
//            preparedStatement.executeQuery();
//
//            String query="select * from students";
//            preparedStatement=connection.prepareStatement(query);
//            ResultSet resultSet=preparedStatement.executeQuery();
//            List<Students> information=new ArrayList<>();
//            while(resultSet.next()){
//                Students students=new Students();
//                students.setStudent_reg(resultSet.getInt("reg_no"));
//                students.setStudent_name(resultSet.getString("name"));
//                students.setAge(resultSet.getInt("age"));
//                students.setEmail(resultSet.getString("email"));
//                students.setDoor_no(resultSet.getInt("door_no"));
//                students.setStreet(resultSet.getString("street"));
//                students.setCity(resultSet.getString("city"));
//                students.setPincode(resultSet.getInt("pincode"));
//                information.add(students);
//
//            }
//
//            RequestDispatcher dispatcher=request.getRequestDispatcher();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
//}
