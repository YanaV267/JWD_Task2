package com.development.task2.util;

public class SphereIdGenerator {
    private static long counter;

    private SphereIdGenerator(){

    }

    public static long getCounter(){
        return counter++;
    }
}
