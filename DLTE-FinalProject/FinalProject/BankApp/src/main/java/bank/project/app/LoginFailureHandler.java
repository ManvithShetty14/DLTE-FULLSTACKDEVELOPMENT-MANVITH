package bank.project.app;
import bank.project.dao.RoleService;
import bank.project.dao.Role;
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
    ResourceBundle resourceBundle = ResourceBundle.getBundle("role");

    @Autowired
    private RoleService roleService;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String userName = request.getParameter("username");
       // String passWord = request.getParameter("password");
        // create the object for the login user
        Role role = roleService.loginByName(userName);
        //if username not exist in table
        if (role == null) {
            exception = new LockedException(resourceBundle.getString("noUser"));
            logger.info("Displays the user does not exist error");
            super.setDefaultFailureUrl("/web/login?error=" + resourceBundle.getString("noUser"));
        } else {
            //if the role status is inactive
            if (role.getRoleStatus().equalsIgnoreCase("inactive")) {
                logger.info(resourceBundle.getString("accDeactivated"));
                exception = new LockedException(resourceBundle.getString("accDeactivated"));
                super.setDefaultFailureUrl("/web/login?error=" + resourceBundle.getString("accDeactivated"));
            } else {
                // increment the failed attempts
                roleService.incrementFailedAttempts(role.getRoleId());
                int attempts = roleService.getAttempts(role.getRoleId());
                //if failed attempts is 1, user has 2 chances left
                if (attempts == 1) {
                    logger.info(resourceBundle.getString("incorrect_pw") + resourceBundle.getString("attempt2"));
                    exception = new LockedException(resourceBundle.getString("attempt2") + resourceBundle.getString("incorrect_pw"));
                    super.setDefaultFailureUrl("/web/login?error=" + resourceBundle.getString("incorrect_pw") + resourceBundle.getString("attempt2"));
                }
                //if failed attempts is 2,user has 1 chances left
                else if (attempts == 2) {
                    logger.info(resourceBundle.getString("incorrect_pw") + resourceBundle.getString("attempt1"));
                    exception = new LockedException(resourceBundle.getString("attempt1") + resourceBundle.getString("incorrect_pw"));
                    super.setDefaultFailureUrl("/web/login?error=" + resourceBundle.getString("incorrect_pw") + resourceBundle.getString("attempt1"));
                }
                //On third wrong attempt , user is deactivated
                else {
                    logger.info(resourceBundle.getString("accDeactivate"));
                    exception = new LockedException(resourceBundle.getString("accDeactivate"));
                    roleService.updateStatus();
                    super.setDefaultFailureUrl("/web/login?error=" + resourceBundle.getString("accDeactivate"));
                }
            }
        }
        super.onAuthenticationFailure(request, response, exception);
    }
}





