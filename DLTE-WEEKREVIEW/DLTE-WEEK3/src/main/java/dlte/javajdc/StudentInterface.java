package dlte.javajdc;

import java.sql.SQLException;

interface StudentInterface {
    void insertRecords(Student student,Address address ) throws SQLException;
    void display() throws SQLException;
    void delete( int reg_no) throws SQLException;
}