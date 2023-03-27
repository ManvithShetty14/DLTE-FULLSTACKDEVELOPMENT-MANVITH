package dlte.javaeeweek;

import oracle.jdbc.driver.OracleDriver;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "InsertServlet" , value = "/insertion")
public class InsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String receivedReg = request.getParameter("reg_no");
        String receivedName = request.getParameter("name");
        String receivedAge = request.getParameter("age");
        String receivedEmail = request.getParameter("email");

        String receivedCDoorNo = request.getParameter("c_door_no");
        String receivedCStreet = request.getParameter("c_street");
        String receivedCCity = request.getParameter("c_city");
        String receivedCPincode = request.getParameter("c_pincode");

        String receivedPDoorNo = request.getParameter("p_door_no");
        String receivedPStreet = request.getParameter("p_street");
        String receivedPCity = request.getParameter("p_city");
        String receivedPPincode = request.getParameter("p_pincode");

        Integer studentReg = Integer.parseInt(receivedReg);
        Integer studentAge = Integer.parseInt(receivedAge);
        Integer studentCDoorNo = Integer.parseInt(receivedCDoorNo);
        Integer studentCPincode = Integer.parseInt(receivedCPincode);
        Integer studentPDoorNo = Integer.parseInt(receivedPDoorNo);
        Integer studentPPincode = Integer.parseInt(receivedPPincode);

        PreparedStatement preparedStatement;

        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
//        logger.log(Level.INFO, studentReg + "," + receivedName + "," + studentAge + "," + receivedEmail + ",");


        try {
            Driver driver = new OracleDriver();
            DriverManager.registerDriver(driver);
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "250601");
            preparedStatement = connection.prepareStatement("alter session set current_schema=MANVITH");
            preparedStatement.executeQuery();

            String query = "insert into student_e values(?,?,?,?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, studentReg);
            preparedStatement.setString(2, receivedName);
            preparedStatement.setInt(3, studentAge);
            preparedStatement.setString(4, receivedEmail);
            int ack1=preparedStatement.executeUpdate();

            String query1 = "insert into address_e values(address_seq.NEXTVAL,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(query1);
            preparedStatement.setInt(1,studentCDoorNo);
            preparedStatement.setString(2,receivedCStreet);
            preparedStatement.setString(3, receivedCCity);
            preparedStatement.setInt(4, studentCPincode);
            preparedStatement.setString(5, "Communication");
            int ack2=preparedStatement.executeUpdate();

            String query2="insert into address_mapper values(?,address_seq.CURRVAL)";
            preparedStatement=connection.prepareStatement(query2);
            preparedStatement.setInt(1,studentReg);
            int ack3=preparedStatement.executeUpdate();

            String query3="insert into address_e values(address_seq.NEXTVAL,?,?,?,?,?)";
            preparedStatement=connection.prepareStatement(query3);
            preparedStatement.setInt(1,studentPDoorNo);
            preparedStatement.setString(2,receivedPStreet);
            preparedStatement.setString(3,receivedPCity);
            preparedStatement.setInt(4,studentPPincode);
            preparedStatement.setString(5,"Permanent");
            int ack4=preparedStatement.executeUpdate();

            String query4="insert into address_mapper values(?,address_seq.CURRVAL)";
            preparedStatement=connection.prepareStatement(query4);
            preparedStatement.setInt(1,studentReg);
            int ack5=preparedStatement.executeUpdate();

            if(ack1>0 && ack2>0 && ack3>0 && ack4>0 && ack5>0){
                RequestDispatcher dispatcher=request.getRequestDispatcher("fetch.jsp");
                logger.log(Level.INFO,"Insertion done!!");
                dispatcher.forward(request,response);
            }
            else{
                RequestDispatcher dispatcher=request.getRequestDispatcher("InsertRecord.jsp");
                logger.log(Level.INFO,"Insertion not done!!");
                dispatcher.forward(request,response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

