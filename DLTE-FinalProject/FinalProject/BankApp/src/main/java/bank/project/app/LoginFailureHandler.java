package bank.project.app;

import bank.project.dao.Role;
import bank.project.dao.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

@Component
public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Autowired
    RoleService roleService;


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("role");
        String username = request.getParameter("username");
        Role role = roleService.loginByName(username);
        if(role!=null){
            if(role.getRoleStatus().equalsIgnoreCase("inactive")) {
                exception = new LockedException(resourceBundle.getString("accDeactivated"));
                super.setDefaultFailureUrl("/web/login/?error="+resourceBundle.getString("accDeactivated"));
            }
            else {
                roleService.updateAttempts(role.getUsername());
                logger.info(resourceBundle.getString("passIncorrect"));
                exception = new LockedException(resourceBundle.getString("passIncorrect"));
                super.setDefaultFailureUrl("/web/login/?error="+resourceBundle.getString("passIncorrect")+" attempts remaining");
                if(role.getFailedAttempts()+1==3) {
                    roleService.updateStatus(role.getUsername());
                    logger.info("Account getting deactivated");
                }
            }
        }
        else {
            exception = new LockedException(resourceBundle.getString("userNotExist"));
            super.setDefaultFailureUrl("/web/login/?error="+resourceBundle.getString("userNotExist"));
        }
        super.onAuthenticationFailure(request, response, exception);
    }
    }




