package dlte.usermethod.springmethod.model;


import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

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
