package com.example.thejava8to11;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {

    public static void main(String[] args) {
        UnaryOperator<String> hi = Greeting::hi;
        // static method 참조하기


        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;
        // 인스턴스 메소드 참조하기

        Supplier<Greeting> constructor_G = Greeting::new;
        Greeting greeting1 = constructor_G.get();
        // 생성자

        Function<String, Greeting> cons = Greeting::new;
        Greeting name = cons.apply("name");
        // 인자를 받는 생성자


        String[] names = {"hyj", "younjeong", "hyj"};
        Arrays.sort(names, String::compareToIgnoreCase);
        //임의의 객체의 인스턴스 메소드 참조
        // "hyj", "younjeong", "hyj" 등의 임의의 객체 인스턴스 메소드를 참조하여 사용한 것.

    }
}
