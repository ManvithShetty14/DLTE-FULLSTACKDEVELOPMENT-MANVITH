package bank.project.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class MvnController {
    @GetMapping("/login")
    public String signin() {
        return "login";
    }
    @GetMapping("/dash")
        public String dash(){
            return "dash";
        }
    @GetMapping("/loan")
    public String loanlist(){
        return "loanlist";
    }
    @GetMapping("/createloan")
    public String loancreate() { return "loancreate";}
    @GetMapping("/customersearch")
    public String cust_search() { return "cust_search";}


}
