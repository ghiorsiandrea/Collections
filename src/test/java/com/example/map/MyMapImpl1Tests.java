package com.example.map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyMapImpl1Tests {


    static final Integer KPRIMERO = 1;
    static final Integer KSEGUNDO = 2;
    static final Integer KTERCERO = 3;

    static final String VPRIMERO = "Hola, soy el primero";
    static final String VSEGUNDO = "Hola, soy el 2";
    static final String VTERCERO = "Hola, soy el 3 LCDTM";

    MyMap<Integer, String> myMap;

    @Test
    void contextLoads() {
    }

    @Test
    void size() {
        int size = myMap.size();
        assertEquals(0, myMap.size());
        //assertEquals(1, myList.size());
    }
}
