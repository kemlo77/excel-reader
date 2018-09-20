package tjanst1;


import greeter.HelloWorld;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExampleTest {


  @Test
   void test1(){
      assertEquals(1,1);
  }

  @Test
   void test2(){
      assertEquals(3,HelloWorld.adder(1,2));
  }

  /**
   * A simple JUnit 5 @ParameterizedTest case using @MethodSource to provide test data.
   * @param person test data used in test
   * @param age test data used in test
   * @param shoeSize test data used in test
   */
  @ParameterizedTest
  @MethodSource("utils.ExcelReader#testValues")
  void test3(String person, int age, float shoeSize){
    System.out.println(person + " " + age +" "+ shoeSize);
  }

}
