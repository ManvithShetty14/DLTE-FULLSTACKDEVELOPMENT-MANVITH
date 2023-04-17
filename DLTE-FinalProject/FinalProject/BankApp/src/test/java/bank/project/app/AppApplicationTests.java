//package bank.project.app;
//
//import bank.project.dao.Role;
//import bank.project.dao.RoleService;
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
//
//    @Test
//    public void listByUsername(){
//        List<Role> role= (List<Role>) roleService.loginByName("Manish");
//        assertTrue(role.isEmpty());
//
//    }
//
//    @Test
//     public void getByUsername(){
//        String uname="mainsh";
//        when(roleService.loginByName(uname)).thenReturn((Role) Stream.of(new Role(102,"Bank Admin","Ensure qualitative services to bank customers.","Inactive",103,"gourav","gourav123",0)).collect(Collectors.toList()));
//        assertEquals(1,roleService.)
//    }
//
//}
