package dlte.spring.method.dltespringmethod.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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
