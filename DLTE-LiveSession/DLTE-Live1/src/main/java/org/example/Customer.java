package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private int customer_id;
    private String customer_name;
    private String email;
    private String pan;
    private int contact;
    private int pin;
    List<Loan> myloan=new ArrayList<>();

}
