package com.api.pay.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class AccountWalletNotfoundException extends PaymentExceptions {
    String detail;

    public AccountWalletNotfoundException(String detail) {
        this.detail = detail;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problemDetail.setTitle("Account not found");
        problemDetail.setDetail(detail);

        return problemDetail;
    }
}
