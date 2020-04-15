package com.mywork.sample.reactivedemo.client

import com.mywork.sample.reactivedemo.DrugResponse
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import reactor.core.scheduler.Scheduler
import reactor.core.scheduler.Schedulers
import java.util.*

@Service
class DrugClient {

    fun drugDetails(): Mono<DrugResponse> {

        println("DrugDetailsDate:"+Date())
        Thread.sleep(5000)
        println("SleepEnd:"+Date())
        val scheduler = Schedulers.elastic()
        return WebClient.builder()
                .baseUrl("http://localhost:8089/drugs-mock")
                .build()
                .get()
                .retrieve().bodyToMono(
                        DrugResponse::class.java
                )
                .subscribeOn(scheduler)


    }

}