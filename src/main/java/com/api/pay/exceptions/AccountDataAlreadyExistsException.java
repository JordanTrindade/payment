package com.api.pay.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class AccountDataAlreadyExistsException extends PaymentExceptions{
    private String detail;

    public AccountDataAlreadyExistsException(String detail) {
        this.detail = detail;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        ProblemDetail problemDetail =  ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        problemDetail.setTitle("Account Data Already Exists");
        problemDetail.setDetail(detail);

        return problemDetail;
    }
}
