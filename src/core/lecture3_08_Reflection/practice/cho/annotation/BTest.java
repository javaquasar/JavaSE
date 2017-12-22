package core.lecture3_08_Reflection.practice.cho.annotation;

class BTest {

  @ToInvoke(run = true)
  public void bFirst() {
    System.out.println("bFirst launched");
  }

  public void bSecond() {
    System.out.println("bSecond launched");
  }

  @ToInvoke
  public void bThird() {
    System.out.println("bThird launched");
  }

}

