package tjanst1;


import greeter.HelloWorld;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExempelTest {


    @Test
     void test1(){
        assertEquals(1,1);
    }

    @Test
     void test2(){
        assertEquals(3,HelloWorld.adder(1,2));
    }

}
