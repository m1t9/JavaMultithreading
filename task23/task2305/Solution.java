package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {

        Solution solution1 = new Solution();
        Solution solution2 = new Solution();

        solution1.innerClasses[0] = solution1.new InnerClass();
        solution1.innerClasses[1] = solution1.new InnerClass();
        solution2.innerClasses[0] = solution1.new InnerClass();
        solution2.innerClasses[1] = solution1.new InnerClass();

        return new Solution[] {solution1, solution2};

    }

    public static void main(String[] args) {

    }
}
