package com.learnkotlin.chapter5;

import java.util.Arrays;

public class Lambdas {

    public void method(int i){

        Arrays.asList("dilip", "scooby")
                .forEach((name)->{
                    System.out.println(i);
                   // i++;
                });
    }
    public static void main(String[] args) {


    }
}
