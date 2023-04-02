package dlte.week4pt2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int reg_no;
    private String name;
    private int age;
    private String email;
    private ArrayList<Address> addresses=new ArrayList<Address>();

    public Student(int reg_no, String name, int age, String email) {
        this.reg_no = reg_no;
        this.name = name;
        this.age = age;
        this.email = email;
    }
}
