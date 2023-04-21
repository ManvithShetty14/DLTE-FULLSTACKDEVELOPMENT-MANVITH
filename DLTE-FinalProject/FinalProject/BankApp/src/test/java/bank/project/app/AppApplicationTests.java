//package bank.project.app;
//
//import bank.project.dao.LoanScheme;
//import bank.project.dao.Role;
//import bank.project.dao.RoleService;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//
//
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//@DataJdbcTest
//class AppApplicationTests {
//    private JdbcTemplate jdbcTemplate;
//    private RoleService roleService;
//
////    @Test
////    void contextLoads() {
////    }
//@Autowired
//RoleService roleService;
//
//    @Test
//    @DisplayName("Test findAll")
//    void testFindAll() {
//        // Setup our mock repository
//        LoanScheme loan1 = new LoanScheme(160,"Home Loan","GharGhar Loan","Need for home to everyone.", (float) 5.8);
//        LoanScheme loan2 = new LoanScheme(162,"Education Loan","Shiksha Loan","Need for education to everyone.", (float) 7.8);
//        doReturn(Arrays.asList(widget1, widget2)).when(repository).findAll();
//
//        // Execute the service call
//        List<Widget> widgets = service.findAll();
//
//        // Assert the response
//        Assertions.assertEquals(2, widgets.size(), "findAll should return 2 widgets");
//    }
//
//}
