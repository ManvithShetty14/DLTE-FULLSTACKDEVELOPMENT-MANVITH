package bank.project.app;

import bank.project.dao.LoanScheme;
import bank.project.dao.Role;
import bank.project.dao.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ResourceBundle;

@RestController
@ComponentScan("bank.project.dao")
public class RoleController {
    private ResourceBundle resourceBundle = ResourceBundle.getBundle("role");
    @Autowired
    private RoleService roleService;
    private Logger logger = LoggerFactory.getLogger(RoleController.class);

    //controller to list all the loan scheme in the bank
    @GetMapping("/display")
    public List<LoanScheme> getLoanScheme() {
        logger.info(resourceBundle.getString("loanList"));
        List<LoanScheme> listloan = roleService.listLoanScheme();
        logger.info(resourceBundle.getString("listedLoan"));
        return listloan;
    }
}
