package bank.project.app;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MvnController {
    @GetMapping("/login")
    public String basic(){
        return "login";
    }
}
