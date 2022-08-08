package com.example.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyPairTests {

    static final String L = "Hola, soy el izquierdo";
    static final String R = "Hola, soy el derecho";

    MyPair<String, String> myPair;

    @BeforeEach
    public void setupBefore() {
        myPair = new MyPair<>(L, R);
    }

    @Test
    void createPairOk() {
        assertEquals(L, myPair.getLeft());
        assertEquals(R, myPair.getRight());
    }

}
