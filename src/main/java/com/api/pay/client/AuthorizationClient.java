package com.api.pay.client;

import com.api.pay.domain.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "AuthorizationClient",
        url = "${client.authorization.service.url}"
)
public interface AuthorizationClient {
    @GetMapping
    ResponseEntity<ResponseDto> isAuthorized();
}
