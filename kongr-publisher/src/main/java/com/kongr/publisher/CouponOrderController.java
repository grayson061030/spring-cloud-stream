package com.kongr.publisher;

import java.util.function.Supplier;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CouponOrderController {

  EmitterProcessor<CouponOrder> directProcessor = EmitterProcessor.create();
  EmitterProcessor<CouponOrder> broadcastProcessor = EmitterProcessor.create();

  @PostMapping(value = "direct")
  public Mono<Void> directMessage(@RequestBody CouponOrder couponOrder) {

    return Mono.just(couponOrder)
        .doOnNext(s -> directProcessor.onNext(couponOrder))
        .then();
  }

  @PostMapping(value = "broadcast")
  public Mono<Void> broadcastMessage(@RequestBody CouponOrder couponOrder) {

    return Mono.just(couponOrder)
        .doOnNext(s -> broadcastProcessor.onNext(couponOrder))
        .then();
  }

  @Bean
  public Supplier<Flux<CouponOrder>> direct() {
    return () -> this.directProcessor;
  }

  @Bean
  public Supplier<Flux<CouponOrder>> broadcast() {
    return () -> this.broadcastProcessor;
  }
}
