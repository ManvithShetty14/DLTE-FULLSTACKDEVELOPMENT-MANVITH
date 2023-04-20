package bank.project.dao;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//POJO class for loanScheme
public class LoanScheme {
    private Integer loanSchemeId;
    private String loanSchemeType;
    private String loanSchemeName;
    private String loanSchemeDesc;
    private Float loanSchemeROI;
}
