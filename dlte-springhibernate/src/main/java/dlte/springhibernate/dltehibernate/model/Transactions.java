package dlte.springhibernate.dltehibernate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long transaction_id;
    @Column(nullable = false)
    private String sender;
    @Column(nullable = false)
    private String receiver;
    @Column(nullable = false)
    private double amount;
    @Column(nullable = false)
    private String type;

}
