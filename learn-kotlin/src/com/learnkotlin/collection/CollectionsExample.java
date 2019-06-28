package com.learnkotlin.collection;

import java.util.Arrays;
import java.util.List;

public class CollectionsExample {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("one","two");
        List<Integer> numList = Arrays.asList(1,3,4,6);
        //System.out.println(numList.max);
        System.out.println(numList.stream().max(Integer::compareTo));
        String[] result = "di.lip".split("\\.");
        System.out.println("Length is : " +  result.length);
        for(int i=0; i<result.length;i++){
            System.out.println("Individual value is " +  result[i]);

        }
    }
}
