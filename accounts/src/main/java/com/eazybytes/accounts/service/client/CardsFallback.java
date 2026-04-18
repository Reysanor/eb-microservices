package com.eazybytes.accounts.service.client;

import com.eazybytes.accounts.dto.CardsDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

// Fallback class for CardsFeignClient to return null response in case of any failure in calling Cards microservice
// This fallback class will be used by Hystrix circuit breaker to return a null response in case of any failure in calling Cards microservice
// This will prevent the entire application from crashing and will return a null response for cards details in case of any failure in calling Cards microservice
@Component
public class CardsFallback implements CardsFeignClient{

    @Override
    public ResponseEntity<CardsDto> fetchCardDetails(String correlationId, String mobileNumber) {
        return null;
    }

}
