package dlte.servlets;

import oracle.jdbc.driver.OracleDriver;
import oracle.jdbc.pool.OracleDataSource;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "AuthorizeServlet", value="/authenticate")
public class AuthorizeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Logger logger =Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        String receivedId=request.getParameter("marketId");
        String receivedPass=request.getParameter("marketPass");
        int markId=Integer.parseInt(receivedId);
        PreparedStatement preparedStatement;
        ResultSet resultSet;


        try {
            Driver driver=new OracleDriver();
//            ServletContext obj=request.getServletContext();
//            OracleDataSource source=new OracleDataSource();
//            source.setUser("system");source.setPassword("250601");
//            source.setURL("jdbc:oracle:thin:@localhost:1521:xe");
//            obj.setAttribute("connection",source);
            DriverManager.registerDriver(driver);
            Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","250601");
            preparedStatement=connection.prepareStatement("alter session set current_schema=MANVITH");
            preparedStatement.executeQuery();

            String query="select * from market where market_id=? and market_pass=?";
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,markId);
            preparedStatement.setString(2,receivedPass);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                logger.log(Level.INFO,"Authenticated");
                RequestDispatcher dispatcher=request.getRequestDispatcher("home.jsp");
                dispatcher.forward(request,response);
            }
            else{
                logger.log(Level.INFO,"Not Authenticated");
                RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request,response);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
