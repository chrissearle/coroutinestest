package com.itera.coroutinestest

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class Router {
    @Bean
    fun routes(handler: Handler) = coRouter {
        GET("/", handler::fetch)
    }
}