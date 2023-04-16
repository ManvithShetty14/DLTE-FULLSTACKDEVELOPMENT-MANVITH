package dlte.login.valid.loginvalid.service;

import dlte.login.valid.loginvalid.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;e
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

//    public  Optional<Role> listOne(String uname,String pass){
//        return Optional.of(jdbcTemplate.queryForObject("select * from role where username=? and password=?", new Object[]{uname}))
//    }

//    public Optional<Role> listOne(String uname,String pass){
//        return Optional.of(jdbcTemplate.queryForObject("select * from bankers where username=? and password=?",new Object[]{id},
//                new BeanPropertyRowMapper<>(Role.class)));
//    }

    public List<Role> listAll(){
        return jdbcTemplate.query("select * from role",new RoleMapper());
    }

    public List<Role> readOne(String name, String pass){
        return jdbcTemplate.query("select * from role where username=? and password=?",new Object[]{name,pass},new RoleMapper());
    }

    class RoleMapper implements RowMapper<Role> {

        @Override
        public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
            Role role=new Role();
            role.setRole_id(rs.getInt("role_id"));
            role.setRole_name(rs.getString("role_name"));
            role.setRole_desc(rs.getString("role_desc"));
            role.setRole_status(rs.getString("role_status"));
            role.setBranch_id(rs.getInt("branch_id"));
            role.setUsername(rs.getString("username"));
            role.setPassword(rs.getString("password"));
            return role;
        }
    }
}
