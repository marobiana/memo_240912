package com.memo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Enum테스트 {

    public enum Status {
        // 열거형 정의
        Y(1, true),
        N(0, false);

        // enum에 정의된 항목 field
        private int value1;
        private boolean value2;

        Status(int value1, boolean value2) { // 생성자
            this.value1 = value1;
            this.value2 = value2;
        }
    }

    @Test
    void status테스트() {
        // given
        Status status = Status.Y;

        // when
        int value1 = status.value1;
        boolean value2 = status.value2;

        // then
        assertEquals(1, value1);
        assertEquals(true, value2);
    }
}
