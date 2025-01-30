package com.api.pay.service;

import com.api.pay.repository.AccountRepository;

import java.math.BigDecimal;

public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    
}
