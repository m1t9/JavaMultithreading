package com.javarush.task.task25.task2512;

/* 
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        getEx(e);
    }

    String getEx(Throwable e) {
        if (e != null){
            getEx(e.getCause());
            System.out.println(e);
        }
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Thread thread = new Thread();
        solution.uncaughtException(thread, new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
//        new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));

    }
}
