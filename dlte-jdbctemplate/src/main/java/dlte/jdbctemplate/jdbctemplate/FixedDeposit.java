package dlte.jdbctemplate.jdbctemplate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FixedDeposit {
    private int depositId;
    private int depositTenure;
    private Float depositAmount;
    private Date depositDate;
    private Float interestRate;
    private Date matureDate;
    private Float matureAmount;
    private String modeOfDivident;
}
