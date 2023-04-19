package bank.project.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;


@Service
public class RoleService implements BankOperations , UserDetailsService {
    ResourceBundle resourceBundle=ResourceBundle.getBundle("role");
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private Logger logger= LoggerFactory.getLogger(Role.class);



    //create a service for user login method
@Override
    public Role loginByName(String name){
        try{
            Role role=jdbcTemplate.queryForObject("select * from role where username=? ",new Object[]{name}, new BeanPropertyRowMapper<>(Role.class));
            logger.warn(resourceBundle.getString("loginquery"));
            return role;
        }catch (DataAccessException e){
            logger.info(resourceBundle.getString("loginexception"+e));
            return null;
        }
}
 // method to update the failed_attempts row int the table
    @Override
    public void updateAttempts(String username) {
        jdbcTemplate.update("update role set failed_attempts = failed_attempts+1 where username=?",username);
    }
  // method to update the role status to inactive
    @Override
    public void updateStatus(String username) {
        jdbcTemplate.update("update role set role_status = 'inactive' where username = ?",username);
    }

    // method to update the failed_attempts to 0
    @Override
    public void loginSuccess(String username) {
        jdbcTemplate.update("update customer set failed_attempts = 0 where username = ?",username);
    }


    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException{
        Role role=loginByName(name);
        if (role==null){
            throw new UsernameNotFoundException(resourceBundle.getString("User not found"));
        }
        return role;
    }

    // service to update the failed attempt record on each login failure
    @Override
    public void failedAttempts(int id){
        jdbcTemplate.update("update role set failed_attempts=failed_attempts+1 where role_id=?",id);
        jdbcTemplate.update("update role set role_status='Inactive' where failed_attempts=3");
        logger.info(resourceBundle.getString("updatequery"));
     }

   // service to list all the loan available in the bank
    @Override
    public List<LoanScheme> listAllLoan(){
    logger.info(resourceBundle.getString("loanlistquery"));
    return jdbcTemplate.query("select * from loan_scheme",new LoanMapper());
    }

    // service to insert the newly available loan to the bank
    @Override
    public String insertLoan(LoanScheme loan_scheme){
    logger.info(resourceBundle.getString("loancreatequery"));
    String info=loan_scheme.getLoanSchemeName()+" has created";
    jdbcTemplate.update("insert into loan_scheme values(loan_scheme_id_seq.NEXTVAL,?,?,?,?,LOCALTIMESTAMP(2))",new Object[]{loan_scheme.getLoanSchemeType(),loan_scheme.getLoanSchemeName(),loan_scheme.getLoanSchemeDesc(),loan_scheme.getLoanSchemeROI()});
    return info;
    }

    class RoleMapper implements RowMapper<Role> {
        @Override
        public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
            Role role=new Role();
            role.setRoleId(rs.getInt("role_id"));
            role.setRoleName(rs.getString("role_name"));
            role.setRoleDesc(rs.getString("role_desc"));
            role.setRoleStatus(rs.getString("role_status"));
            role.setBranchId(rs.getInt("branch_id"));
            role.setUsername(rs.getString("username"));
            role.setPassword(rs.getString("password"));
            role.setFailedAttempts(rs.getInt("failed_attempts"));
            return role;
        }
    }

    class LoanMapper implements  RowMapper<LoanScheme> {

        @Override
        public LoanScheme mapRow(ResultSet rs, int rowNum) throws SQLException{
            LoanScheme loan_scheme=new LoanScheme();
            loan_scheme.setLoanSchemeId(rs.getInt("loan_scheme_id"));
            loan_scheme.setLoanSchemeType(rs.getString("loan_scheme_type"));
            loan_scheme.setLoanSchemeName(rs.getString("loan_scheme_name"));
            loan_scheme.setLoanSchemeDesc(rs.getString("loan_scheme_desc"));
            loan_scheme.setLoanSchemeROI(rs.getFloat("loan_scheme_roi"));
            return loan_scheme;
        }

    }

}
