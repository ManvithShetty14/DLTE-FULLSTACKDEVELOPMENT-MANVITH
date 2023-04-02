package dlte.javajdc;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class StudentOptionsTest {

    @org.junit.jupiter.api.Test
    void delete() throws SQLException {
        StudentOptions studentOptions=new StudentOptions();
        String obj=studentOptions.delete(789);
        assertEquals("deleted",obj);

    }
}