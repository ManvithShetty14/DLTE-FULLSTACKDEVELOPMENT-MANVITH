import lombok.SneakyThrows;
import oracle.jdbc.driver.OracleDriver;
import org.example.DaoOperation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "AuthorizeServlet", value = "/authenticate")
public class AuthorizeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer customerId=Integer.parseInt(request.getParameter("cust_id"));
        Integer pinId=Integer.parseInt(request.getParameter("pin"));
        Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
//        try {
//            DaoOperation daoOperation=new DaoOperation();
//            String cust=daoOperation.login(customerId,pinId);
//            System.out.println(cust);
//            logger.log(Level.INFO,"Login Confirmed");
//            if(!cust.equals(null)){
//                RequestDispatcher dispatcher=request.getRequestDispatcher("dashboard.jsp");
//                HttpSession session=request.getSession();
//                session.setAttribute("cust",cust);
//                dispatcher.forward(request,response);
//            }else
//                {
//                RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
//                dispatcher.forward(request,response);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        Driver driver=new OracleDriver();
        try {
            DriverManager.registerDriver(driver);
            Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","250601");
            PreparedStatement preparedStatement = connection.prepareStatement("alter session set current_schema=MANVITH");
            preparedStatement.executeQuery();
            String query="select * from customer_e where customer_id=? and pin=?";
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,customerId);
            preparedStatement.setInt(2,pinId);
            logger.log(Level.INFO,""+customerId+""+pinId);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                RequestDispatcher requestDispatcher=request.getRequestDispatcher("dashboard.jsp");
                logger.log(Level.INFO,"Authenticated");
                requestDispatcher.forward(request,response);
            }else{
                RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
                logger.log(Level.WARNING,"Not Authenticated");
                dispatcher.forward(request,response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
