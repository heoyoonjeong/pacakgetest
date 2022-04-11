package com.example.thejava8to11;

import java.util.function.*;

public class Foo {
    private void run() {
        int baseNum = 10;

        // local class
        // baseNum을 내부에서 선언하면 외부에 있는 baseNum을 가릴 수 있다.
        class LocalClass {
            void printBaseNum() {
                int baseNum = 30;
                System.out.println(baseNum);
            }
        }

        // 익명클래스
        Consumer<Integer> anonymousClass = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNum) {
                System.out.println( 1 + baseNum);
            }
        };

        // 람다식
        // 람다식의 내부 스콥은 바깥 스콥과 같다. 따라서 동일한 이름인 baseNum을 추가로 정의할 수 없다.
        IntConsumer printInt = i -> System.out.println(i + baseNum);
    }

    public static void main2(String[] args) {

        final int baseNumber = 10;
        RunSomthing runSomthing = (number) -> number + baseNumber;

        System.out.println(runSomthing.doit(1));
        System.out.println(runSomthing.doit(1));

        Plus10 p10 = new Plus10();
        System.out.println(p10.apply(10));

        Function<Integer, Integer> fun20 = i -> i*20;
        System.out.println(p10.compose(fun20).apply(10));
        // compose와 andthen 은 두개의 인터페이스를 합칠 수 있다.
        System.out.println(p10.andThen(fun20).apply(10));


        Consumer<Integer> printT = System.out::println;
        // 인자로 받는 타입만 정의하고 void 함수

        Supplier<Integer> get10 = () -> 10;
        // return 할 타입만 정의

        Predicate<String> startsWithH = (s) -> s.startsWith("H");
        // boolean  타입으로 리턴하는 함수

        UnaryOperator<Integer> plus10 = i -> i + 10;
        // Funtional operator인데 인자와 리턴타입이 동일한 경우 사용

        BinaryOperator<Integer> plus10and20 = (i1, i2) -> i1 + i2;
        // BiFuntional operator 와 동일한데 모든 타입이 같은 인터페이스
    }
}