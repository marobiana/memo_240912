package com.memo;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Enum테스트1 {

    public enum CalcType {
        // 열거형 정의
        CALC_A(value -> value),
        CALC_B(value -> value * 10),
        CALC_C(value -> value * 3),
        CALC_ETC(value -> 0);

        // 필드
        private Function<Integer, Integer> expression; // enum에 정의된 function

        // 메소드
        // 생성자
        CalcType(Function<Integer, Integer> expression) {
            this.expression = expression;
        }
        
        // 계산 적용 메소드
        public int calculate(int value) {
            return expression.apply(value);
        }
    }

    @Test
    void enum테스트() {
        // given
        CalcType type = CalcType.CALC_ETC;

        // when
        int result = type.calculate(500);

        // then
        assertEquals(0, result);
    }
}
