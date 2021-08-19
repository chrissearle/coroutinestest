package com.itera.coroutinestest

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyAndAwait
import org.springframework.web.reactive.function.server.json

@Component
class Handler(val webClient: WebClient) {

    suspend fun fetch(request: ServerRequest): ServerResponse {
        val searchResults: Deferred<String> = GlobalScope.async {
            webClient.get()
                .uri("https://itera.com")
                .header(
                    "User-agent",
                    "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.2; Trident/4.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30"
                )
                .header("Accept-Encoding", "gzip")
                .retrieve()
                .awaitBody()
        }

        return ServerResponse.ok()
            .json()
            .bodyAndAwait(listOf(Site(searchResults.await()!!)))
    }

}