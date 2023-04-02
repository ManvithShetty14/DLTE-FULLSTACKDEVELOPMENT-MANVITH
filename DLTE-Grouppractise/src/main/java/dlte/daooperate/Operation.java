package dlte.daooperate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface Operation {
    public int insertDb(Student student);
    List<Student> fetch() throws SQLException;
    List<Address> fetchAddress(int reg_no) throws SQLException;
    public String deleteDb(int reg_no);
    public Connection makeConnection();

}
