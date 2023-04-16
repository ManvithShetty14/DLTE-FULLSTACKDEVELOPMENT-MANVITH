package bank.project.app;

import bank.project.dao.Role;
import bank.project.dao.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
@ComponentScan("bank.project.dao")
@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/lists")
    public List<Role> callList(){
        return roleService.listAll();
    }


}
