package com.api.pay.config;

import com.api.pay.domain.Account;
import com.api.pay.domain.dto.AccountDTO;
import com.api.pay.enums.AccountType;
import com.api.pay.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final AccountRepository accountRepository;

    public DataLoader(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @Override
    public void run(String... args) throws Exception {

        Account account = new Account("jordan","110.538.576-08","jordan@gmial.com","1234", AccountType.CLIENT);
        account.credit(BigDecimal.valueOf(200));
        accountRepository.save(account);

    }
}
