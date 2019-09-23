package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {

//        Map<String, String> map = new HashMap<>();
////        map.put("name" , "Ivanov");
////        map.put("country" , "Ukraine");
//        map.put("age", null);
////        map.put("city", "Kiyv");
////
//        System.out.println(getQuery(map));

    }
    public static String getQuery(Map<String, String> params) {

        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet()) {

            if (entry.getValue() != null) {

                result.append(entry.getKey() + " = '" + entry.getValue() + "' and ");

            }
        }

        if (result.length() != 0) {
            String resultString = result.toString().substring(0, result.length() - 5);
            return resultString;
        }
        return "";

    }
}
