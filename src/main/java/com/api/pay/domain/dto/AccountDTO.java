package com.api.pay.domain.dto;

import com.api.pay.domain.Account;
import com.api.pay.enums.AccountType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AccountDTO(@NotBlank String fullname,
                         @NotBlank String cpfCnpj,
                         @NotBlank String email,
                         @NotBlank String password,
                         @NotNull AccountType accountType) {



    public Account toAccount(){
        return new Account(fullname, cpfCnpj, email,password, accountType);
    }

}
