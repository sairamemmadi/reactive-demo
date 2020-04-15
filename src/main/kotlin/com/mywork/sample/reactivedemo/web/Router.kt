package com.mywork.sample.reactivedemo.web

import com.mywork.sample.reactivedemo.DrugResponse
import com.mywork.sample.reactivedemo.client.DateClient
import com.mywork.sample.reactivedemo.client.DrugClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.server.*
import org.springframework.web.reactive.function.server.RequestPredicates.GET
import reactor.core.publisher.Mono
import org.springframework.web.reactive.function.server.RequestPredicates.path
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Flux
import reactor.core.scheduler.Scheduler
import reactor.core.scheduler.Schedulers
import java.util.stream.Stream


@RestController
class Router(val handler: Handler) {

    /*@RequestMapping("/api/test/drug/details")
     public fun routing(): Mono<ServerResponse> {

        return ServerResponse.ok().body(handler(), DrugResponse::class.java)
     }*/


    @Bean
    fun composedRoutes(): RouterFunction<ServerResponse> {

        return RouterFunctions.route()
                .GET("/api/test/drug/details") { req -> handler.handler(req, "TEST1") }
                .GET("/api/test/drug/detail1") { req -> handler.handler(req, "TESTING SAIRAM") }
                .build()


    }


//        return ServerResponse.ok().body(handler(), DrugResponse::class.java)


}

@Component
class Handler(val client: DrugClient, val dateClient: DateClient) {
    fun handler(request: ServerRequest, requestVal: String): Mono<ServerResponse> {

        println("Handler...::$requestVal")
        val scheduler = Schedulers.parallel()



        Flux.zip(
                client.drugDetails().subscribeOn(scheduler),
                dateClient.dateDetails().subscribeOn(scheduler)
        ).subscribe { result ->
            println("1st:" + result.t1)
            println("2nd:" + result.t2)
        }
        return ServerResponse.ok().body(client.drugDetails(), DrugResponse::class.java)
    }

}