package org.example;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a Flux or Mono
        Flux<String> seq1 = Flux.just("foo", "bar", "foobar");

        List<String> iterable = Arrays.asList("foo", "bar", "foobar");
        Flux<String> seq2 = Flux.fromIterable(iterable);

        Mono<String> noData = Mono.empty();
        Mono<String> data = Mono.just("foo");
        Flux<Integer> numbersFromFiveToSeven = Flux.range(5, 3);

        numbersFromFiveToSeven.subscribe(value -> System.out.println(value));

        // subscribe
        // basic
        Flux<Integer> ints1 = Flux.range(1, 3);
        ints1.subscribe();

        // lambda
        Flux<Integer> ints2 = Flux.range(1,3);
        ints2.subscribe(i -> System.out.println(i));

        // error
//        Flux<Integer> ints3 = Flux.range(1, 4)
//                .map(i -> {
//                   if(i <= 3) return i;
//                   throw new RuntimeException("Got to 4");
//                });
//
//        ints3.subscribe(i -> System.out.println(i),
//                error -> System.err.println("Error:" + error));

        // completion events
        Flux<Integer> ints4 = Flux.range(1, 4);
        ints4.subscribe(i -> System.out.println(i),
                error -> System.out.println("Error " + error),
                () -> System.out.println("Done"));
    }
}