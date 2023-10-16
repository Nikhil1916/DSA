// multi interface concept

interface  A{
  public int xyz = 10;
  public int sample();
}

interface B {
    public int sample();
    public int sample1();
}

// in interface we write extends instead of implements
interface C extends A,B{
   public int sample2();
}

class Sample implements C {
  public int sample() {
    return 100;
  }

  public int sample1() {
    return 1000;
  }

  public int sample2() {
    return 10000;
  }
  
}

public class Main3 {
  public static void main(String args[]) {
    Sample s = new Sample();
    System.out.println(s.sample());
  }
}
