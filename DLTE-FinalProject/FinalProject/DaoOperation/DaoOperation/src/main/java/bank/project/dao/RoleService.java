package bank.project.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;


@Service
public class RoleService implements BankOperations{
    ResourceBundle resourceBundle=ResourceBundle.getBundle("role");
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private Logger logger= LoggerFactory.getLogger(Role.class);

//    public  Optional<Role> listOne(String uname,String pass){
//        return Optional.of(jdbcTemplate.queryForObject("select * from role where username=? and password=?", new Object[]{uname}))
//    }

//    public Optional<Role> listOne(String uname,String pass){
//        return Optional.of(jdbcTemplate.queryForObject("select * from bankers where username=? and password=?",new Object[]{id},
//                new BeanPropertyRowMapper<>(Role.class)));
//    }

//    public List<Role> listAll(){
//        return jdbcTemplate.query("select * from role",new RoleMapper());
//    }

//    @Override
//    public int getAttempts(int id){
//        int attempt=jdbcTemplate.queryForObject("select failed_attempts from role where role_id=?",Integer.class,id);
//       return attempt;
//    }
//
//    @Override
//    public  void setAttempts(int id){
//
//        jdbcTemplate.update("update role set failed_attempts=3 where role_id=?",id);
//    }
//
//    public void reduceAttempts(int id){
//        jdbcTemplate.update("update role set failed_attempts = failed_attempts-1 where role_id=?",id);
//    }
//
//    public void updateStatus(){
//        jdbcTemplate.update("update role set role_status='inactive' failed_attempts=0");
//
//    }

@Override
    public Role loginByName(String name){
        try{

            Role role=jdbcTemplate.queryForObject("select * from role where username=? ",new RoleMapper(),name);
            logger.warn("the query is executed");
            return role;
        }catch (DataAccessException e){
            return null;
        }

    }

//    public UserDetails loadByUsername(String name) throws UsernameNotFoundException{
//        Role role=readOne(name);
//        if (role==null){
//            throw new UsernameNotFoundException(resourceBundle.getString("User not found"));
//        }
//        return role;
//    }

    @Override
    public void failedAttempts(int id){
        jdbcTemplate.update("update role set failed_attempts=failed_attempts+1 where role_id=?",id);
        jdbcTemplate.update("update role set role_status='Inactive' where failed_attempts=3");
    }

//    @Override
//    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException{
//        Role role=readOne(name);
//        if(role==null){
//            throw new UsernameNotFoundException(resourceBundle.getString("user does not exist"));
//        }
//        return role;
//    }

    @Override
    public List<Loan_scheme> listAllLoan(){
        return jdbcTemplate.query("select * from loan_scheme",new LoanMapper());
    }

    @Override
    public String insertion(Loan_scheme loan_scheme){
    jdbcTemplate.update("insert into loan_scheme values(loan_scheme_id_seq.NEXTVAL,?,?,?,?)",new Object[]{loan_scheme.getLoanSchemeType(),loan_scheme.getLoanSchemeName(),loan_scheme.getLoanSchemeDesc(),loan_scheme.getLoanSchemeROI()});
    return "created";
    }

    class RoleMapper implements RowMapper<Role> {

        @Override
        public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
            Role role=new Role();
            logger.info("Ready to be received");
            role.setRoleId(rs.getInt("role_id"));
            role.setRoleName(rs.getString("role_name"));
            role.setRoleDesc(rs.getString("role_desc"));
            role.setRoleStatus(rs.getString("role_status"));
            role.setBranchId(rs.getInt("branch_id"));
            role.setUsername(rs.getString("username"));
            role.setPassword(rs.getString("password"));
            role.setFailedAttempts(rs.getInt("failed_attempts"));
            logger.info("Ready to be viewed");
            return role;
        }
    }

    class LoanMapper implements  RowMapper<Loan_scheme> {

        @Override
        public Loan_scheme mapRow(ResultSet rs,int rowNum) throws SQLException{
            Loan_scheme loan_scheme=new Loan_scheme();
            loan_scheme.setLoanSchemeId(rs.getInt("loan_scheme_id"));
            loan_scheme.setLoanSchemeType(rs.getString("loan_scheme_type"));
            loan_scheme.setLoanSchemeName(rs.getString("loan_scheme_name"));
            loan_scheme.setLoanSchemeDesc(rs.getString("loan_scheme_desc"));
            loan_scheme.setLoanSchemeROI(rs.getFloat("loan_scheme_roi"));
            return loan_scheme;
        }

    }
}

