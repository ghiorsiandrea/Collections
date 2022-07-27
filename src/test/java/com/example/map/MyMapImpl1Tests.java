package com.example.map;

import com.example.list.MyListImpl1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyMapImpl1Tests {


    static final Integer KPRIMERO = 1;
    static final Integer KSEGUNDO = 2;
    static final Integer KTERCERO = 3;

    static final String VPRIMERO = "Hola, soy el primero";
    static final String VSEGUNDO = "Hola, soy el 2";
    static final String VTERCERO = "Hola, soy el 3 LCDTM";

    private MyMap<Integer, String> myMap;
    @BeforeEach
    public void setupBefore() {
        myMap = new MyMapImpl1<>();
    }

    @Test
    void createEmptyListOk() {
        assertEquals(0, myMap.size());
    }



}
