package com.api.pay.service;

import com.api.pay.domain.Account;
import com.api.pay.domain.dto.AccountDTO;
import com.api.pay.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    public Account createAccount(AccountDTO accountDTO){
        Account account = accountRepository.findBycpfCnpjOrEmail(accountDTO.cpfCnpj(), accountDTO.email());
        if(account != null){
            System.out.println("Account already exists");
        }
        return accountRepository.save(accountDTO.toAccount());
    }
    
}
