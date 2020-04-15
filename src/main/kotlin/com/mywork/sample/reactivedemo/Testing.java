package com.mywork.sample.reactivedemo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Testing {

    public static void main(String args[]) {
        double amt1 = 2.15;

        double amt22 = 1.10;
        Integer test = new Integer(12);
        System.out.println("difference between 2.15 and 1.0 using double is: " + (amt1 - amt22));

        BigDecimal amt3 = new BigDecimal("2.15");
        BigDecimal amt4 = new BigDecimal("1.10");
        System.out.println("difference between 2.15 and 1.0 using double is: " + (amt3.subtract(amt4)));


        BigDecimal amt5 = new BigDecimal(2.15);
        BigDecimal amt6 = new BigDecimal(1.10);
        System.out.println("difference between 2.15 and 1.0 using double is: " + (amt5.subtract(amt6)));

        String a = new String("sairam");
        String b = new String("sairam");

        if (a == b)
            System.out.println("a==b");
        else
            System.out.println("a!=b");

        if (a.equals(b))
            System.out.println("a.equalsTo-b");
        else
            System.out.println("a.isNotEqualsTo-b");

        if (a.compareTo(b) == 0)
            System.out.println("hashCodeEqual" + a.hashCode() + ":" + b.hashCode());

        List list = new ArrayList<String>();


    }

    public int speed(int distance, int time) {
        if (distance < 0 || time <= 0) {
            throw new IllegalArgumentException("distance: " + distance
                    + " time: " + time);
        }
        return distance / time;
    }
}
