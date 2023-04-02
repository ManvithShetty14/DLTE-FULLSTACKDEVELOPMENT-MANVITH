package handlers;

import oracle.jdbc.driver.OracleDriver;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "AuthorizeServlet", value = "/authorize")
public class AuthorizeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResourceBundle bundle=ResourceBundle.getBundle("student");
        String uname=bundle.getString("duname") ;
        String pass=bundle.getString("dpass");
        Logger logger= Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


        Driver driver=new OracleDriver();

        try {

            DriverManager.registerDriver(driver);
            Connection connection=DriverManager.getConnection(bundle.getString("OracleJDBC.url"),bundle.getString("OracleJDBC.username"), bundle.getString("OracleJDBC.password"));
            String query="select * from login where uname=? and pass=? ";

            PreparedStatement preparedStatement = connection.prepareStatement("alter session set current_schema=MANVITH");
            preparedStatement.executeQuery();
            logger.log(Level.INFO,"query executed");
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,uname);
            preparedStatement.setString(2,pass);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
                logger.log(Level.INFO,"LOGGEDDD IN SUCCESS");
                dispatcher.forward(request,response);
            }else{
                logger.log(Level.INFO,"FAIILED");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
