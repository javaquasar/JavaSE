package core.lecture3_08_Reflection.practice.cho.annotation;

import java.lang.reflect.*;
@Contains
class ATest {

  public void aFirst() {
    System.out.println("aFirst launched");
  }

  @ToInvoke
  public void aSecond() {
    System.out.println("aSecond launched");
  }
  @ToInvoke(run=true)
  public void aThird() {
    System.out.println("aThird launched");
  }
}
