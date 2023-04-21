package bank.project.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class MvnController {
    //url authorization for the login page
    @GetMapping("/login")
    public String signin() {
        return "login";
    }
    //url authorization for the dashboard
    @GetMapping("/dash")
    public String dash(){
            return "dash";
        }
        //url authorization for the display all loan in bank
    @GetMapping("/loan")
    public String loanlist(){
        return "loanlist";
    }
    //url authorization for the loan creation
    @GetMapping("/createloan")
    public String loancreate() { return "loancreate";}
    //url authorization for the customer search
    @GetMapping("/customersearch")
    public String cust_search() { return "cust_search";}
    //url authorization for approval list
    @GetMapping("/approval")
    public String approval() { return "approval";}
    //url authorization for home page
    @GetMapping("/home")
    public String homepage() { return "homepage";}

}
