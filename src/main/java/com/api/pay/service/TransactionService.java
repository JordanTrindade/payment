package com.api.pay.service;

import com.api.pay.domain.Account;
import com.api.pay.domain.Transaction;
import com.api.pay.domain.dto.TransactionDto;
import com.api.pay.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransactionService {
    private final AccountRepository accountRepository;
    private final AuthorizationClientService authorizationClientService;
    private final NotificationClientService notificationClientService;

    public TransactionService(AccountRepository accountRepository, AuthorizationClientService authorizationClientService, NotificationClientService notificationClientService) {
        this.accountRepository = accountRepository;
        this.authorizationClientService = authorizationClientService;
        this.notificationClientService = notificationClientService;
    }

    //receber o pedido
        //validar as carteiras (saldo e tipo)
            //validar autorizador
    //realizar transferencia

    public Transaction validTransfer(TransactionDto transactionDto){
        Account sender =  accountRepository.findById(transactionDto.senderId()).orElse(null);
        Account reciever =  accountRepository.findById(transactionDto.recieverId()).orElse(null);
        BigDecimal value = transactionDto.value();

        //valida se o sender pode realizar transferencia
        if (!sender.isMerchantAccount())System.out.println("Account not merchant");;
        //valida saldo da carteira
        if (!sender.hasSufficientBalance(value)) System.out.println("Account have not balance");;

        if(!authorizationClientService.isAuthorized())System.out.println("Authorized client is out");

        sender.debit(value);
        reciever.credit(value);

        accountRepository.save(sender);
        accountRepository.save(reciever);

        return new Transaction(sender,reciever, value);
    }



}
