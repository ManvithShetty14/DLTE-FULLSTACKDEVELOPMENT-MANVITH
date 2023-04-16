package bank.project.app;

import bank.project.dao.Loan_scheme;
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


    @GetMapping("/display")
    public List<Loan_scheme> callLoanList() {
        logger.info(resourceBundle.getString("loanList"));
        List<Loan_scheme> listloan = roleService.listAllLoan();
        logger.info(resourceBundle.getString("listedLoan"));
        return listloan;
    }

    @PostMapping("/createloan")
    public String adding(@RequestParam("loanType") String loanType,@RequestParam("loanName") String loanName,@RequestParam("loanDesc") String loanDesc,@RequestParam("loanROI") Float loanROI){
        Loan_scheme loan_scheme=new Loan_scheme();

        loan_scheme.setLoanSchemeType(loanType);
        loan_scheme.setLoanSchemeName(loanName);
        loan_scheme.setLoanSchemeDesc(loanDesc);
        loan_scheme.setLoanSchemeROI(loanROI);
        return roleService.insertion(loan_scheme);
    }

//    @GetMapping("/loanlist")
//    public List<Loan_scheme> callList(){
//        logger.info("Loans are listed");
//        return roleService.listAll();
//    }


}
