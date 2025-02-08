package com.api.pay.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class PaymentExceptions extends RuntimeException{

    public ProblemDetail toProblemDetail(){
        ProblemDetail problemDetail =  ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        problemDetail.setDetail("payment internal server error");

        return problemDetail;
    }

    public static class transactionNotAuthorized extends PaymentExceptions {
        public transactionNotAuthorized() {
        }

        @Override
        public ProblemDetail toProblemDetail() {
            ProblemDetail problemDetail =  ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
            problemDetail.setTitle("Transaction not authorized");
            problemDetail.setDetail("Authorization service not authorized");

            return problemDetail;
        }
    }
}
