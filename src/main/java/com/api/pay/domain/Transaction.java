package com.api.pay.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private Account reciever;

    @ManyToOne
    private Account sender;
    
    private BigDecimal value;

}
