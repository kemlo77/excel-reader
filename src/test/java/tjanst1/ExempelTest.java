package tjanst1;


import greeter.HelloWorld;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

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

  @ParameterizedTest
  @MethodSource("utils.ExcelReader#testVarden")
  void test3(String a,String b, String c){
    System.out.println(a + " " + b);
  }

}
