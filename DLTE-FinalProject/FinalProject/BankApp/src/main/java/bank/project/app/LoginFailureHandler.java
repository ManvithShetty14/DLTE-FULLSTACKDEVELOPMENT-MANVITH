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
        String passWord = request.getParameter("password");
        Role role = roleService.loginByName(userName);
        if (role == null) {
            exception = new LockedException(resourceBundle.getString("db_user"));
            super.setDefaultFailureUrl("/web/login?error=" + resourceBundle.getString("db_user"));
        } else {
            if (role.getRoleStatus().equalsIgnoreCase("inactive")) {
                logger.info(resourceBundle.getString("db_unsuccessfull"));
                exception = new LockedException(resourceBundle.getString("db_unsuccessfull"));
                super.setDefaultFailureUrl("/web/login?error=" + resourceBundle.getString("db_unsuccessfull"));
            } else {
                roleService.incrementFailedAttempts(role.getRoleId());
                int attempts = roleService.getAttempts(role.getRoleId());
                if (attempts == 1) {
                    logger.info(resourceBundle.getString("db_incorrect_pw") + resourceBundle.getString("attempt2"));
                    exception = new LockedException(resourceBundle.getString("attempt2") + resourceBundle.getString("db_incorrect_pw"));
                    super.setDefaultFailureUrl("/web/login?error=" + resourceBundle.getString("db_incorrect_pw") + resourceBundle.getString("attempt2"));
                } else if (attempts == 2) {
                    logger.info(resourceBundle.getString("db_incorrect_pw") + resourceBundle.getString("attempt1"));
                    exception = new LockedException(resourceBundle.getString("attempt1") + resourceBundle.getString("db_incorrect_pw"));
                    super.setDefaultFailureUrl("/web/login?error=" + resourceBundle.getString("db_incorrect_pw") + resourceBundle.getString("attempt1"));
                } else {
                    logger.info(resourceBundle.getString("db_unsuccessfull"));
                    exception = new LockedException(resourceBundle.getString("db_unsuccessfull"));
                    roleService.updateStatus();
                    super.setDefaultFailureUrl("/web/login?error=" + resourceBundle.getString("db_unsuccessfull"));
                }
            }
        }
        super.onAuthenticationFailure(request, response, exception);

    }
}



