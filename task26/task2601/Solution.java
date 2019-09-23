package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution{

    public static void main(String[] args) {

        Integer[] arr = new Integer[]{13, 8, 15, 5, 17};
        arr = sort(arr);
        for (Integer num : arr) {
            System.out.println(num);
        }

    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);
        double median;
        if (array.length % 2 == 0)
            median = ((double)array[array.length/2] + (double)array[array.length/2 - 1])/2;
        else
            median = (double) array[array.length/2];

        Arrays.sort(array,(x,y)->Integer.compare(Math.abs((int) median-x), Math.abs((int) median-y)));
        return array;
    }
}
