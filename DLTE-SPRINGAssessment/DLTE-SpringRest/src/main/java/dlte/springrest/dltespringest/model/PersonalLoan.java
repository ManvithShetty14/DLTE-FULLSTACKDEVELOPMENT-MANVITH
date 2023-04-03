package dlte.springrest.dltespringest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PersonalLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer loan_req_number;
    @Column(nullable = false)
    private float req_amount;
    @Column(nullable = false)
    private int cibil;
    @Column(nullable = false)
    private long aadhar;
    @Column(nullable = false)
    private String pan;
    @Column(nullable = false)
    private String profession;
    @Column(nullable = false)
    private float incomePerAnnum;
    @Column(nullable = false)
    private String statusApproval;
    @Column Date dateOfRequest;
}
