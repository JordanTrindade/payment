package com.api.pay.controller;

import com.api.pay.domain.Transaction;
import com.api.pay.domain.dto.TransactionDto;
import com.api.pay.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    ResponseEntity<Transaction> transfer(@RequestBody @Valid TransactionDto transactionDto){
        Transaction transaction = transactionService.validTransfer(transactionDto);

        return ResponseEntity.status(HttpStatus.OK).body(transaction);
    }


}
