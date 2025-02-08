package com.api.pay.service;

import com.api.pay.client.AuthorizationClient;
import com.api.pay.domain.Account;
import com.api.pay.domain.Transaction;
import com.api.pay.enums.AccountType;
import com.api.pay.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TransactionService {
    private final AccountRepository accountRepository;


    public TransactionService(AccountRepository accountRepository, AuthorizationClient authorizationClient) {
        this.accountRepository = accountRepository;
    }

    //receber o pedido
        //validar as carteiras (saldo e tipo)
            //validar autorizador
    //realizar transferencia

    public void transaction(Transaction transaction){

    }

    public Boolean validAccount(Long senderId,Long recieverId){
        Account sender =  accountRepository.findById(senderId).orElse(null);
        Account reciever =  accountRepository.findById(recieverId).orElse(null);

        //valida se as contas existem
        if(Objects.isNull(reciever) || Objects.isNull(sender)){
            return false;
        }

        //valida se o sender pode realizar transferencia
        if(sender.getAccountType().equals(AccountType.MERCHANT)){
            return false;
        }

        return true;
    }
}
