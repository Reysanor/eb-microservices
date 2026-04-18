package com.eazybytes.gatewayserver.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import reactor.core.publisher.Mono;

// Filter to trace the response and add a correlation id to the response header if it is not present.
@Configuration
public class ResponseTraceFilter {

    private static final Logger logger = LoggerFactory.getLogger(ResponseTraceFilter.class);

    @Autowired
    FilterUtility filterUtility;

    // implementing the GlobalFilter interface to create a global filter that is executed for all the requests.
    // used by RequestTraceFilter to add the correlation id to the response header.
    // This filter is executed after the request is forwarded to the downstream services.
    @Bean
    public GlobalFilter postGlobalFilter() {
        return (exchange, chain) -> {
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                HttpHeaders requestHeaders = exchange.getRequest().getHeaders();
                String correlationId = filterUtility.getCorrelationId(requestHeaders);

                if(!(exchange.getResponse().getHeaders().containsKey(filterUtility.CORRELATION_ID))) {
                    logger.debug("Updated the correlation id to the outbound headers: {}", correlationId);
                    exchange.getResponse().getHeaders().add(filterUtility.CORRELATION_ID, correlationId);
                }

            }));
        };
    }
}