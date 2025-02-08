package com.api.pay.service;

import com.api.pay.client.NoticationClient;
import com.api.pay.domain.Transaction;
import com.api.pay.exceptions.PaymentExceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class NotificationClientService {

    private final NoticationClient noticationClient;
    private final Logger logger = LoggerFactory.getLogger(NotificationClientService.class);

    public NotificationClientService(NoticationClient noticationClient) {
        this.noticationClient = noticationClient;
    }

    public void sendNotification(Transaction transaction){
        try {
            logger.info("Sending notification");
            ResponseEntity<Void> res = noticationClient.sendNotification(transaction);
            if(res.getStatusCode().isError()){
                logger.error("Error while sending notification");
            }
        }catch (PaymentExceptions paymentExceptions){
            logger.error("Error while sending notification");
        }
    }
}
