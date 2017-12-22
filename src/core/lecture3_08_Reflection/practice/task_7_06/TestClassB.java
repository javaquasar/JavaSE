package core.lecture3_08_Reflection.practice.task_7_06;

class TestClassB {

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

