package com.api.pay.controller;

import com.api.pay.domain.Account;
import com.api.pay.domain.dto.AccountDTO;
import com.api.pay.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody AccountDTO accountDTO){
        Account account = accountService.createAccount(accountDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(account);
    }

}
