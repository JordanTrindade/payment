package com.api.pay.service;

import com.api.pay.domain.Account;
import com.api.pay.domain.Transaction;
import com.api.pay.domain.dto.TransactionDto;
import com.api.pay.exceptions.AccountWalletNotfoundException;
import com.api.pay.exceptions.HasNotSufficientBalance;
import com.api.pay.exceptions.PaymentExceptions;
import com.api.pay.exceptions.TransactionIsNotAllowedForAccoutType;
import com.api.pay.repository.AccountRepository;
import com.api.pay.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;

@Service
public class TransactionService {
    private final AccountRepository accountRepository;
    private final AuthorizationClientService authorizationClientService;
    private final NotificationClientService notificationClientService;
    private final TransactionRepository transactionRepository;

    public TransactionService(AccountRepository accountRepository, AuthorizationClientService authorizationClientService, NotificationClientService notificationClientService, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.authorizationClientService = authorizationClientService;
        this.notificationClientService = notificationClientService;
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public Transaction validTransfer(TransactionDto transactionDto){
        Account sender =  accountRepository.findById(transactionDto.senderId()).orElseThrow(() -> new AccountWalletNotfoundException("Account not found, 404"));
        Account reciever =  accountRepository.findById(transactionDto.recieverId()).orElseThrow(() -> new AccountWalletNotfoundException("Account not found, 404"));
        BigDecimal value = transactionDto.value();

        //valida se o sender pode realizar transferencia
        if (sender.isMerchantAccount()) throw new TransactionIsNotAllowedForAccoutType("Account not allowed",sender);
        //valida saldo da carteira
        if (sender.hasNotSufficientBalance(value)) throw new HasNotSufficientBalance("Balance insuficient",value);
        //verica servico autorizador
        if(!authorizationClientService.isAuthorized()) throw new PaymentExceptions.transactionNotAuthorized();

        sender.debit(value);
        reciever.credit(value);

        accountRepository.save(sender);
        accountRepository.save(reciever);

        Transaction transaction = new Transaction(sender,reciever, value);
        transactionRepository.save(transaction);

        //thread para envio da noticacao async para nao impactar o fluxo caso algo aconteca com o servico de notificacao
        CompletableFuture.runAsync(()-> notificationClientService.sendNotification(transaction));

        return transaction;
    }
}
