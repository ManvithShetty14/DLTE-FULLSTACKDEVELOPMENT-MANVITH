package dlte.daooperate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int regno;
    private String name;
    private String email;
    private int age;
    private List<Address> addresses =new ArrayList<>();
}
