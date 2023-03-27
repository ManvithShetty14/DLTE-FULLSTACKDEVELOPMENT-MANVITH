package dlte.javaeeweek;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Students {
  private int student_reg;
  private String student_name;
  private int age;
  private String email;
  private int door_no;
  private String street;
  private String city;
  private int pincode;
}
