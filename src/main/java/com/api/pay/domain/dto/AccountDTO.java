package com.api.pay.domain.dto;

import com.api.pay.domain.Account;
import com.api.pay.enums.AccountType;

public record AccountDTO(String fullname,
                         String cpfCnpj,
                         String email,
                         String password,
                         AccountType accountType) {



    public Account toAccount(){
        return new Account(fullname, cpfCnpj, email,password, accountType);
    }

}
