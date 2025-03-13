package com.memo;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Slf4j
public class 람다테스트 {

    //@Test
    void 람다테스트1() {
        List<String> list = List.of("apple", "banana", "cherry");
        list.stream()  // 줄줄이 이어짐
                .filter(fruit -> fruit.startsWith("b")) // 필터링
                .forEach(fruit -> log.info(fruit));
    }

    //@Test
    void 람다테스트2() {
        List<String> list = List.of("apple", "banana", "cherry");
        list = list.stream()
                .map(fruit -> fruit.toUpperCase()) // stream
                .collect(Collectors.toList()); // stream to list
        log.info(list.toString());
    }

    //@Test
    void 메소드레퍼런스() {
        List<String> list = List.of("apple", "banana", "cherry");
        list = list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        log.info(list.toString());
    }

    @AllArgsConstructor
    @ToString
    class Person {
        private String name;
        private int age;

        public void printInfo() {
            log.info(this.toString());
        }
    }

    @Test
    void 테스트4() {
        List<Person> people = new ArrayList<>();
        people.add(new Person( "신보람", 30));
        people.add(new Person( "김바다", 6));

        // lambda
        people.forEach(p -> p.printInfo());
        // method reference
        people.forEach(Person::printInfo);

        // println으로 출력
        people.forEach(p -> System.out.println(p));
        people.forEach(System.out::println);
    }
}








