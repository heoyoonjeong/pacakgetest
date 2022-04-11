package com.example.spring_gateway_test.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration
public class FilterConfig {

   // @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/first-service/**")
                        .filters(f -> f.addRequestHeader("first-request", "first-req-val")
                                .addResponseHeader("first-response", "first-res-val"))
                        .uri("http://localhost:8081")
                )
                .route(r -> r.path("/second-service/**")
                        .filters(f -> f.addRequestHeader("second-request", "sec-req-val")
                                .addResponseHeader("second-response", "sec-res-val"))
                        .uri("http://localhost:8082")
                )
                .build();
    }
}
