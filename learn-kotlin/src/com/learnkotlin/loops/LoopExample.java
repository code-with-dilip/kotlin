package com.learnkotlin.loops;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class LoopExample {

    static List<String> referenceList = Arrays.asList("A", "B", "C");

    static Function<String, Boolean> isAvailable = (input) -> {
        return referenceList.contains(input);
    };

    public static void main(String[] args) {

        System.out.println(isAvailable.apply("C"));

    }
}
