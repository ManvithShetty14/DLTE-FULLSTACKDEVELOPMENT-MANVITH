package dlte.spring.dltespringentity.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int trans_id;

    @Column(nullable = false)
    private String date;
    @Column(nullable = false)
    private int amount;
    @Column(nullable = false)
    private String sender;
    @Column(nullable = false)
    private String receiver;

    @Column(nullable = false)
    private String type;

}
