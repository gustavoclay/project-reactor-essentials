package reactive.test;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@Slf4j
/**
 * Reactive Streams
 * 1. Asynchronous
 * 2. Non-blocking
 * 3. Backpreassure
 * Publisher <- (subscribe) Subscriber
 * Subscription is created
 * Publisher (onSubscribe with the subscription) -> Subscriber
 * Subscription <- (request N) Subscriber
 * Publisher -> (onNext) Subscriber
 * until:
 * 1. Publisher send all the objects requested.
 * 2. Publisher send all the objects is has. (onComplete) subscriber and
 * subscripition will be canceled.
 * 3. There is an error. (onError) -> subscriber and subscription will be
 * canceled
 */
public class MonoTest {

    @Test
    public void test() {
        log.info("Everything working as intended");
    }

    @Test
    public void monoSubscriber() {
        var name = "Gustavo Clay";
        Mono<String> mono = Mono.just(name).log();

        mono.subscribe();

        log.info("-----------------");

        StepVerifier.create(mono)
            .expectNext(name)
            .verifyComplete();
    }

}
