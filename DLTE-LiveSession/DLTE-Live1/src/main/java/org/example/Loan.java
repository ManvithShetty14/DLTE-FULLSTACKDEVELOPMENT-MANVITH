package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Loan {
    private int loan_number;
    private String borrower_name;
    private String loan_type;
    private int loan_amount;
    private String loan_issued_date;

}
