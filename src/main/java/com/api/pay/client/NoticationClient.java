package com.api.pay.client;

import com.api.pay.domain.Transaction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(
        url = "${https://run.mocky.io/v3/e197981e-2fec-4223-b8ef-b20646ff1a21}"
)
public interface NoticationClient {

    @PostMapping
    ResponseEntity<Void> sendNotification(@RequestBody Transaction transaction);

}
