package com.guigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetWayConfig {

    @Bean
    public RouteLocator custermerRouteLocator(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        RouteLocator locator = routes
                .route("path-baidu", r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei"))
                .build();
        return locator;
    }

}
