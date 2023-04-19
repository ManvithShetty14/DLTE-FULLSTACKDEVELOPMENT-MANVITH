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


import static org.junit.jupiter.api.Assertions.*;
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

    // junit testing on the service listAllLoan()
    @Test
    public void testListLoan() {
        LoanScheme homeLoan=new LoanScheme(160,"Home Loan","GharGhar Loan","Need for home to everyone.", (float) 5.8);
        LoanScheme vehicleLoan=new LoanScheme(180,"Vehicle Loan","Savaari Yojana","Buy the much needed dream vehicle.", (float) 7.8);
        LoanScheme educationLoan=new LoanScheme(185,"Education Loan","Shiksha Yojana","Need to provide quality education to everyone.", (float) 6.8);
        LoanScheme personalLoan=new LoanScheme(190,"Personal Loan","Jeevan Yojana","You can use the funds from this loan for any legitimate financial need.", (float) 8.2);
        List<LoanScheme> tempList = Stream.of(homeLoan,vehicleLoan).collect(Collectors.toList());
        when(jdbcTemplate.query(eq("select * from loan_scheme"),any(RowMapper.class))).thenReturn(tempList);
        assertNotEquals(0, roleService.listAllLoan().indexOf(vehicleLoan));
    }

    // junit testing on the method loginByName()
    @Test
    public void testLoginByName(){
        Role bankAdmin = new Role(102,"Bank Admin","Ensure qualitative services to bank customers.","Active",201,"amruth","amruth123",1);
        String username="amruth";
        when(jdbcTemplate.queryForObject(eq("select * from role where username=? "), eq(new Object[]{username}), any(RowMapper.class))).thenReturn(bankAdmin);
        Role admin=roleService.loginByName(username);
        assertSame(bankAdmin,admin);
    }

    // junit testing on the service insertLoan()
    @Test
    public void testInsertLoan(){
        LoanScheme homeLoan=new LoanScheme(120,"Home loan","Ghar Yojana","The loan based on the idea to have home to everyone.", (float) 8.6);
        LoanScheme vehicleLoan=new LoanScheme(121,"Vehicle loan","Vaahan Yojana","The loan based on the idea to have vehicle to everyone.", (float) 7.9);
        when(jdbcTemplate.update(eq("insert into loan_scheme values(?,?,?,?,?)"), eq(new Object[]{homeLoan.getLoanSchemeId(),homeLoan.getLoanSchemeType(),homeLoan.getLoanSchemeName(),homeLoan.getLoanSchemeDesc(),homeLoan.getLoanSchemeROI()})))
                .thenReturn(1);
        String data=roleService.insertLoan(homeLoan);
        assertEquals("Ghar Yojana has created",data);
    }

}
