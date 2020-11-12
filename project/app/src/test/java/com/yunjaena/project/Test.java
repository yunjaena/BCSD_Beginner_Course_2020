package com.yunjaena.project;

public class Test {
    @org.junit.Test
    private void addition_isCorrect() {
        Flyable bee = new Bee();
        Flyable airplane = new Airplane();
        bee.fly();
        airplane.fly();
    }
}
