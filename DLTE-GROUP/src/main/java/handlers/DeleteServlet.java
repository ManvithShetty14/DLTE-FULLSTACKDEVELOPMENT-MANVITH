package handlers;

import dlte.daooperate.DaoOperate;
import dlte.daooperate.IdNotFoundException;
import dlte.daooperate.Operation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "DeleteServlet" , value="/delete")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        ResourceBundle bundle = ResourceBundle.getBundle("student");
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


        int reg_no = Integer.parseInt(request.getParameter("reg_no"));
        Operation daOoperations = new DaoOperate();
        daOoperations.deleteDb(reg_no);
        logger.log(Level.INFO, bundle.getString("dbDelete"));

        printWriter.write(daOoperations.deleteDb(reg_no));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
