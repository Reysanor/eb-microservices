package com.eazybytes.gatewayserver.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

// Filter to trace the request and add a correlation id to the request header if it is not present.
// This filter is executed before the request is forwarded to the downstream services.
// The correlation id is used to trace the request across multiple services and to identify the request in the logs.

@Order(1) // This filter is executed before the ResponseTraceFilter which is executed after the request is forwarded to the downstream services.
@Component
// Extending the GlobalFilter interface to create a global filter that is executed for all the requests.
public class RequestTraceFilter implements GlobalFilter {

    private static final Logger logger = LoggerFactory.getLogger(RequestTraceFilter.class);

    @Autowired
    FilterUtility filterUtility;

    // Mono<Void> filter is the method that is executed for each request. It takes the ServerWebExchange and the GatewayFilterChain as parameters.
    // It is used for tracking the requests using correlation id.

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpHeaders requestHeaders = exchange.getRequest().getHeaders();
        // Check if the correlation id is present in the request header. If it is present, log the correlation id.
        // If it is not present, generate a new correlation id and add it to the request header.
        if (isCorrelationIdPresent(requestHeaders)) {
            logger.debug("eazyBank-correlation-id found in RequestTraceFilter : {}",
                    filterUtility.getCorrelationId(requestHeaders));
        } else {
            String correlationID = generateCorrelationId();
            exchange = filterUtility.setCorrelationId(exchange, correlationID);
            logger.debug("eazyBank-correlation-id generated in RequestTraceFilter : {}", correlationID);
        }
        return chain.filter(exchange);
    }

    private boolean isCorrelationIdPresent(HttpHeaders requestHeaders) {
        if (filterUtility.getCorrelationId(requestHeaders) != null) {
            return true;
        } else {
            return false;
        }
    }

    private String generateCorrelationId() {
        return java.util.UUID.randomUUID().toString();
    }

}
