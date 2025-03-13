package com.memo;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Slf4j
public class 객체정렬하기 {
    @ToString
    @AllArgsConstructor
    class Data {
        int count;
    }

    @Test
    void 테스트() {
        // given
        Data d1 = new Data(3);
        Data d2 = new Data(5);
        Data d3 = new Data(2);

        List<Data> list = new ArrayList<>(List.of(d1, d2, d3));
        log.info("as-is: {}", list.toString());

        // when -> 정렬
        //정렬_고전(list);
        정렬_람다(list);

        // then
        log.info("to-be: {}", list.toString());
    }

    void 정렬_고전(List<Data> list) {  // d1, d2, d3
        Collections.sort(list, new Comparator<>() {
            @Override
            public int compare(Data o1, Data o2) {
                return Integer.compare(o1.count, o2.count);
            }
        });
    }

    void 정렬_람다(List<Data> list) {
        Collections.sort(list, (o1, o2) -> Integer.compare(o1.count, o2.count));
    }
}
