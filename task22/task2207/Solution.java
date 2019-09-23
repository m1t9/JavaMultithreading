package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName =  bufferedReader.readLine();
//        String fileName = "D:\\prg\\JavaRushTasks\\JavaRushTasks\\3.JavaMultithreading\\src\\com\\javarush\\task\\task22\\task2207\\file";
        bufferedReader.close();


        bufferedReader = new BufferedReader(new FileReader(fileName));

        ArrayList<String> list = new ArrayList<String>();
        String line;

        while (bufferedReader.ready()) {
            list.addAll(Arrays.asList(bufferedReader.readLine().split("\\s+")));
        }
        bufferedReader.close();

        Map<String, String> map = new HashMap<>();
        
        for (int i = 0; i < list.size(); i++)
        {
            String item = list.get(i);
            StringBuilder itemReverseBuilder = new StringBuilder(item);
            String itemReverse = itemReverseBuilder.reverse().toString();

            {
                for (int j = i + 1; j < list.size(); j++)
                {
                    if (map.containsKey(item)) {continue;}
                    if (map.containsKey(itemReverse)) {continue;}


                    StringBuilder sb = new StringBuilder(list.get(j));
                    String reverse = sb.reverse().toString();

                    if (item.equals(reverse))
                    {
                        map.put(item, sb.reverse().toString());
                    }
                }
            }
        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            Pair pair = new Pair();
            pair.first = entry.getKey();
            pair.second = entry.getValue();

            result.add(pair);
        }

        for (Pair pair : result) {
            System.out.println(pair.first + " " + pair.second);
        }


    }

    public static class Pair {
        String first;
        String second;

        public Pair() {

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                        first == null ? second :
                            second == null ? first :
                                first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
