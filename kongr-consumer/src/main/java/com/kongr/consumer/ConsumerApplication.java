package com.kongr.consumer;

import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@SpringBootApplication
public class ConsumerApplication {

  public static void main(String[] args) {
    SpringApplication.run(ConsumerApplication.class, args);
  }

  @Bean
  public Function<Flux<CouponOrder>, Mono<Void>> direct() {
    return couponOrderFlux -> couponOrderFlux.doOnNext(
        couponOrder -> log.info("##### CouponOrder for direct : {}", couponOrder.toString()))
        .then();
  }

  @Bean
  public Function<Flux<CouponOrder>, Mono<Void>> broadcast() {
    return couponOrderFlux -> couponOrderFlux.doOnNext(
        couponOrder -> log.info("##### CouponOrder for broadcast : {}", couponOrder.toString()))
        .then();
  }
}
