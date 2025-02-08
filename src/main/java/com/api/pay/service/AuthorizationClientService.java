package com.api.pay.service;

import com.api.pay.client.AuthorizationClient;
import com.api.pay.domain.Transaction;
import com.api.pay.exceptions.PaymentExceptions;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationClientService {
    private final AuthorizationClient authorizationClient;

    public AuthorizationClientService(AuthorizationClient authorizationClient) {
        this.authorizationClient = authorizationClient;
    }

    public Boolean isAuthorized(){
        var response = authorizationClient.isAuthorized();
        if(response.getStatusCode().isError()){
            throw new PaymentExceptions();
        }
        return response.getBody().Authorized();
    }

}
