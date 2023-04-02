package dlte.week4pt2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private int address_id;
    private int door_no;
    private String street;
    private String city;
    private int pincode;
    private String type;
}

