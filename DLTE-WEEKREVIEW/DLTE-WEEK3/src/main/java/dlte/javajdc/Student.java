package dlte.javajdc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int reg_no;
    private String name;
    private int age;
    private String email;
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class Address{
    private Integer door;
    private String street;
    private String city;
    private Integer pin;
}
