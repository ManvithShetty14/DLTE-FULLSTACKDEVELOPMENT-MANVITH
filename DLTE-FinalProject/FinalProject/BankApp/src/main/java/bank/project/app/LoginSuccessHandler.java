package bank.project.app;

import bank.project.dao.Role;
import bank.project.dao.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

@Component
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Autowired
    RoleService roleService;
    private Logger logger = LoggerFactory.getLogger(RoleService.class);
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Role role = (Role) authentication.getPrincipal();
        ResourceBundle resourceBundle=ResourceBundle.getBundle("role");

            //on success login
            logger.info("Move in success handler");
            //set failed attempts to 0 to that user
            roleService.setAttempts(role.getRoleId());
            //move to the next page
            super.setDefaultTargetUrl("/web/dash");

            super.onAuthenticationSuccess(request, response, authentication);
    }
}
