package com.api.pay.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false) // Corrigido
    private Account sender;

    @ManyToOne
    @JoinColumn(name = "reciever_id", nullable = false) // Corrigido
    private Account reciever;

    @Column(nullable = false)
    private BigDecimal amount;

    // 🔥 Construtor sem argumentos (obrigatório para o JPA)
    public Transaction() {}

    public Transaction(Account reciever, Account sender, BigDecimal value) {
        this.reciever = reciever;
        this.sender = sender;
        this.amount = value;
    }

    // Getters e Setters (recomendado para persistência)
    public UUID getId() {
        return id;
    }

    public Account getReciever() {
        return reciever;
    }

    public Account getSender() {
        return sender;
    }

    public BigDecimal getValue() {
        return amount;
    }
}
