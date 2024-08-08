package com.example.cloud.gateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallBackController {

    @RequestMapping("/restaurantFallBack")
    public Mono<String> restaurantServiceFallBack()
    {
        return Mono.just("Restaurant service is taking too long to respond or is down.Please try again later");
    }
    @RequestMapping("/orderFallBack")
    public Mono<String> orderServiceFallBack()
    {
        return Mono.just("Order service is taking too long to respond or is down.Please try again later");
    }
}
