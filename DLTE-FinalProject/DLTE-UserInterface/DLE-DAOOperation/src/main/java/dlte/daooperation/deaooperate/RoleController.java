package dlte.daooperation.deaooperate;

import dlte.login.valid.loginvalid.model.Role;
import dlte.login.valid.loginvalid.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@ComponentScan("dlte.login.valid.loginvalid")
@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/")
    public List<Role> callList(){
        return roleService.listAll();
    }

}
