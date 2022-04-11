package com.example.thejava8to11;

// 추상 메서드가 하나만 있으면 함수형 인터페이스
@FunctionalInterface
public interface RunSomthing {
    int doit(int num);

    static void printName(){
        System.out.println("hyj");
    }

    default void printAge(){
        System.out.println("30");
    }
}
