package bank.project.dao;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class DaoApplicationTests {

    @Mock
    JdbcTemplate jdbcTemplate;

    @InjectMocks
    RoleService roleService;

    @Test
    public void testlistLoan() {
        Loan_scheme loan1=new Loan_scheme(160,"Home Loan","GharGhar Loan","Need for home to everyone.", (float) 5.8);
        Loan_scheme loan2=new Loan_scheme(180,"Vehicle Loan","Savaari yojana","Buy the much needed dream vehicle.", (float) 7.8);
        List<Loan_scheme> tempList = Stream.of(loan1,loan2).collect(Collectors.toList());
        when(jdbcTemplate.query(eq("select * from loan_scheme"),any(RowMapper.class))).thenReturn(tempList);
        assertEquals(1, roleService.listAllLoan().indexOf(loan2));
    }

    @Test
    public void testgetByUsername() {
        Role role = new Role(102,"Bank Admin","Ensure qualitative services to bank customers.","Active",201,"ashish","ashish123",1);
        String uname = "ashish";
        when(jdbcTemplate.queryForObject(eq("select * from role where username=?"),any(RowMapper.class),eq(uname))).thenReturn(role);
        Role role1 = roleService.loginByName("ashish");
        assertEquals(role.getUsername(),role1.getUsername());
   }



}
