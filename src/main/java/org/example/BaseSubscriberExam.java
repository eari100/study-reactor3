package org.example;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

public class BaseSubscriberExam {
    public static void main(String[] args) {
        SampleSubscriber<Integer> ss = new SampleSubscriber<>();
        Flux<Integer> ints = Flux.range(1, 4);
        ints.subscribe(ss);
    }

    public static class SampleSubscriber<T> extends BaseSubscriber<T> {

        @Override
        public void hookOnSubscribe(Subscription subscription) {
            System.out.println("Subscribed");
            request(1);
        }

        @Override
        public void hookOnNext(T value) {
            System.out.println(value);
            request(1);
        }
    }
}


