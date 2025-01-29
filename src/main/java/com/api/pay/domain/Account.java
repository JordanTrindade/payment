package com.api.pay.domain;

import com.api.pay.enums.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String cpfCnpj;

    @Column(unique = true)
    private String email;

    private String senha;

    private BigDecimal amount;

    private AccountType accountType;
}
