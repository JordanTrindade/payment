package com.api.pay.exceptions;

import com.api.pay.domain.Account;
import com.api.pay.enums.AccountType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class TransactionIsNotAllowedForAccoutType extends PaymentExceptions {
    private String title;
    private Account account;

    public TransactionIsNotAllowedForAccoutType(String title, Account account) {
        this.title = title;
        this.account = account;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        problemDetail.setTitle(title);
        problemDetail.setDetail("Account is : " + account.getAccountType().toString());

        return problemDetail;
    }
}
