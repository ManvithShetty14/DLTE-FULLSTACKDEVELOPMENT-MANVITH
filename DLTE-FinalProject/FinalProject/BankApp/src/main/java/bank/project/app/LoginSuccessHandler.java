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

@Component
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Autowired
    RoleService roleService;
    private Logger logger = LoggerFactory.getLogger(RoleService.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Role role = (Role) authentication.getPrincipal();
        logger.info(role.toString());
        logger.info(" in success handler");
// if(customer.getAttempts()==0)
// logger.info("deactivate");
        if (role.getRoleStatus().equalsIgnoreCase("Inactive")) {
            logger.info("Inactive");
            super.setDefaultTargetUrl("/logout");
        } else {
            roleService.setAttempts(role.getRoleId());
            super.setDefaultTargetUrl("/web/dash");
        }
            super.onAuthenticationSuccess(request, response, authentication);

    }
}
