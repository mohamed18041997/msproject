package com.microservice.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfiguration {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("classRoomModule", r -> r.path("/api/classroom/**")
                        .filters(f -> f.retry(retryConfig -> retryConfig
                                .setRetries(3)
                                .setStatuses(org.springframework.http.HttpStatus.SERVICE_UNAVAILABLE)
                                .setMethods(org.springframework.http.HttpMethod.GET, org.springframework.http.HttpMethod.POST)))
                        .uri("lb://classRoom-service")
                )
                .route("studentModule", r -> r.path("/api/student/**")
                        .filters(f -> f.retry(retryConfig -> retryConfig
                                .setRetries(3)
                                .setStatuses(org.springframework.http.HttpStatus.SERVICE_UNAVAILABLE)
                                .setMethods(org.springframework.http.HttpMethod.GET, org.springframework.http.HttpMethod.POST)))
                        .uri("lb://student-services")
                )
                .build();
    }
}
