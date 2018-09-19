package tjanst1;

import org.junit.Assert;
import org.junit.Test;
import greeter.HelloWorld;

public class ExempelTest {


    @Test
    public void test1(){
        Assert.assertEquals(1,2);
    }

    @Test
    public void test2(){
        Assert.assertEquals(3,HelloWorld.adder(1,2));
    }

}
