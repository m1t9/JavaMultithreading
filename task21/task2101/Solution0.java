//package com.javarush.task.task21.task2101;
//
//import java.util.ArrayList;
//
///*
//Определяем адрес сети
//*/
//public class Solution0 {
//    public static void main(String[] args) {
//        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
//        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
//        byte[] netAddress = getNetAddress(ip, mask);
//        print(ip);          //11000000 10101000 00000001 00000010
//        print(mask);        //11111111 11111111 11111110 00000000
////        print(netAddress);  //11000000 10101000 00000000 00000000
//    }
//
//    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
//
//        ArrayList<String> ipBinary = new ArrayList<String>();
//        ArrayList<String> maskBinary = new ArrayList<String>();
//
//        for (byte item : ip) {
//            String binaryItem = String.format("%8s", Integer.toBinaryString(item & 0xFF)).replace(" ", "0");
//            ipBinary.add(binaryItem);
//        }
//
//        for (byte item : mask) {
//            String binaryItem = String.format("%8s", Integer.toBinaryString(item & 0xFF)).replace(" ", "0");
//            maskBinary.add(binaryItem);Solution0
//        }
//
//        ArrayList<String> netAddressBinary = new ArrayList<String>();
//
//        for (int i = 0; i < ipBinary.size(); i++) {
//            String bLogicSum = "";
//            for (int j = 0; j < ipBinary.get(i).length(); j++) {
//                boolean ipA = true;
//                boolean maskB = true;
//                if (ipBinary.get(i).split("")[j].equals("0")
//                    ipA = false;
//                if (maskBinary.get(i).split("")[j].equals("0"))
//                    maskB = false;
//                if (ipA && maskB)
//                    bLogicSum +=
//            }
//        }
//
//
//        return new byte[4];
//    }
//
//    public static void print(byte[] bytes) {
//
//    }
//}
