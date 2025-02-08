package com.api.pay.controller;

import com.api.pay.exceptions.AccountDataAlreadyExistsException;
import com.api.pay.exceptions.PaymentExceptions;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(PaymentExceptions.class)
    public ProblemDetail PaymentExceptions(PaymentExceptions paymentExceptions){
       return paymentExceptions.toProblemDetail();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail MethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){

        List<toDetail> erros = methodArgumentNotValidException.getFieldErrors()
                .stream()
                .map(fieldError -> new toDetail(fieldError.getField(),fieldError.getRejectedValue(),fieldError.getDefaultMessage()))
                .toList();

        ProblemDetail problemDetail = ProblemDetail.forStatus(org.springframework.http.HttpStatus.BAD_REQUEST);
        problemDetail.setTitle("Your request parameters didn't validate.");
        problemDetail.setProperty("invalid-params",erros);

        return problemDetail;
    }

    private record toDetail(String property, Object reject ,String detail){}

}
