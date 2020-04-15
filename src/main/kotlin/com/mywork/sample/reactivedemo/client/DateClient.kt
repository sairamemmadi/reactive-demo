package com.mywork.sample.reactivedemo.client

import com.mywork.sample.reactivedemo.DateResponse
import com.mywork.sample.reactivedemo.DrugResponse
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import reactor.core.scheduler.Scheduler
import reactor.core.scheduler.Schedulers
import java.util.*

@Service
class DateClient {

    fun dateDetails(): Mono<DateResponse> {
        println("DateClientStart:"+ Date())

        val scheduler = Schedulers.elastic()
        return WebClient.builder()
                .baseUrl("http://localhost:8089/date-mock")
                .build()
                .get()
                .retrieve().bodyToMono(
                        DateResponse::class.java
                )
                .subscribeOn(scheduler)


    }

}