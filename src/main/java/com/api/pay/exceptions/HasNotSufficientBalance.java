package com.api.pay.exceptions;

import com.api.pay.domain.Account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

import java.math.BigDecimal;

public class HasNotSufficientBalance extends PaymentExceptions {

        private String title;
        private BigDecimal value;

        public HasNotSufficientBalance(String title, BigDecimal value) {
            this.title = title;
            this.value = value;
        }

        @Override
        public ProblemDetail toProblemDetail() {
            ProblemDetail problemDetail =  ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
            problemDetail.setTitle(title);
            problemDetail.setDetail("Value: " + value );

            return problemDetail;
        }
}
