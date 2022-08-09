package com.example.util;

import com.example.map.MyMapImpl1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void given_TheSamePair_ThenEqualsReturnTrue() {
        assertEquals(myPair, myPair);
    }

    @Test
    void given_ANewIdenticPair_ThenEqualsReturnTrue() {
        assertEquals(myPair, new MyPair<>(L, R));
    }

    @Test
    void given_ANewDifferentPair_ThenEqualsReturnFalse() {
        assertNotEquals(myPair, new MyPair<>(L, "B"));
    }

    @Test
    void given_ADifferentPairWithNull_ThenEqualsReturnFalse() {
        assertNotEquals(myPair, new MyPair<>(L, null));
    }

    @Test
    void given_DifferentClasses_Then_EqualsShouldReturnFalse() {
        MyMapImpl1<String, String> myMap = new MyMapImpl1<>();
        myMap.put("AA", "A");
        myMap.put("BB", "B");
        assertNotEquals(myPair, myMap);
    }

}
