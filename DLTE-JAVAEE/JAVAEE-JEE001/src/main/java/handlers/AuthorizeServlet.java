package handlers;

import oracle.jdbc.driver.OracleDriver;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name="AuthorizeServlet", value = "/authenticate")
public class AuthorizeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    }
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
    String receiveId=request.getParameter("customerId");
    String receivePass=request.getParameter("customerPass");
    int custId=Integer.parseInt(receiveId);

        try {
            Driver driver=new OracleDriver();
            DriverManager.registerDriver(driver);
            Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","250601");
            String query="select * from customer where cust_id=? and password=?";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,custId);
            preparedStatement.setString(2,receivePass);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                RequestDispatcher dispatcher=request.getRequestDispatcher("dash.jsp");
                dispatcher.forward(request,response);
            }
            else{
                RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
