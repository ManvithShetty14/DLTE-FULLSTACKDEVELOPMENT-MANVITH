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

    // controller to user login method
    @PostMapping("/signin")
    public String authentication(@RequestParam("uname") String uname, @RequestParam("pass") String pass) {
        logger.info("values are entered:");
        Role role = roleService.loginByName(uname);
        if (role == null) {
            logger.info(resourceBundle.getString("userNotExist"));
            return resourceBundle.getString("userNotExist");
        } else {
            logger.info(role.getRoleStatus());
            if (role.getRoleStatus().equalsIgnoreCase("Inactive")) {
                logger.info(resourceBundle.getString("deactivateAccount"));
                return resourceBundle.getString("deactivateAccount");
            }
            if (!pass.equals(role.getPassword())) {
                roleService.failedAttempts(role.getRoleId());
                logger.info(resourceBundle.getString("passwordWrong"));
                return resourceBundle.getString("passwordWrong");
            }
            else {
                logger.info(resourceBundle.getString("loginSuccess"));
                return resourceBundle.getString("loginSuccess");
            }
        }

    }

    //controller to list all the loan in the bank
    @GetMapping("/display")
    public List<LoanScheme> getLoanList() {
        logger.info(resourceBundle.getString("loanList"));
        List<LoanScheme> listloan = roleService.listAllLoan();
        logger.info(resourceBundle.getString("listedLoan"));
        return listloan;
    }

    //controller to create a new loan to the bank
    @PostMapping("/createloan")
    public String addNewLoan(@RequestParam("loanType") String loanType,@RequestParam("loanName") String loanName,@RequestParam("loanDesc") String loanDesc,@RequestParam("loanROI") Float loanROI){
        logger.info(resourceBundle.getString("loancreate"));
        LoanScheme loan_scheme=new LoanScheme();
        loan_scheme.setLoanSchemeType(loanType);
        loan_scheme.setLoanSchemeName(loanName);
        loan_scheme.setLoanSchemeDesc(loanDesc);
        loan_scheme.setLoanSchemeROI(loanROI);
        logger.info(resourceBundle.getString("createloan"));
        return roleService.insertLoan(loan_scheme);
    }

}
