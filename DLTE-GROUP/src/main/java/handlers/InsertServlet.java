package handlers;

import dlte.daooperate.DaoOperate;
import dlte.daooperate.Operation;
import dlte.daooperate.Student;
import dlte.daooperate.Address;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "InsertServlet", value="/insert")
public class InsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResourceBundle bundle=ResourceBundle.getBundle("student");
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        int dbreg_no = Integer.parseInt(bundle.getString("dbreg_no"));
        String dbName = bundle.getString("dbName");
        int dbAge = Integer.parseInt(request.getParameter("dbAge"));
        String dbEmail = request.getParameter("dbEmail");

        String Door_No = request.getParameter("Door_No");
        String Locality = request.getParameter("Locality");
        String City = request.getParameter("City");
        int Pincode = Integer.parseInt(request.getParameter("Pincode"));

        String P_Door = request.getParameter("P_Door_No");
        String P_Locality = request.getParameter("P_Locality");
        String P_City = request.getParameter("P_City");
        int P_Pincode = Integer.parseInt(request.getParameter("P_Pincode"));

        List<Address> address=new ArrayList<>();
        Address address1=new Address(P_Door,P_Locality,P_City,P_Pincode);
        Address address2=new Address(Door_No,Locality,City,Pincode);
        address.add(address1);
        address.add(address2);
        Student student = new Student(dbreg_no,dbName,dbEmail,dbAge,address);

        Operation daOoperations = new DaoOperate();
        daOoperations.insertDb(student);

        logger.log(Level.INFO,bundle.getString("dbS"));
        PrintWriter printWriter=response.getWriter();

        if (daOoperations.insertDb(student) != 1) {

            logger.info(bundle.getString("dbInsertError"));
            printWriter.write(bundle.getString("dbInsertError"));
        }
        else {
            logger.info(bundle.getString("dbInsert"));
            printWriter.write(bundle.getString("dbInsert"));
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
