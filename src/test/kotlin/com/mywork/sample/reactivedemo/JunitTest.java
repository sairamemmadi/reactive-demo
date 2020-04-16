package com.mywork.sample.reactivedemo;


import com.mywork.sample.reactivedemo.test.Testing;
import org.junit.Assert;
import org.junit.Test;

public class JunitTest {

    @Test(expected = IllegalArgumentException.class)
    public void test(){
        System.out.println("speed");
        int distance = 5;
        int time = 0;
        Testing instance = new Testing();
        int expResult = 0;
        int result = instance.speed(distance, time); //shold throw exception
        Assert.assertEquals(expResult, result);




    }

}
