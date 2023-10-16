class A {
  void helper() {
    System.out.println("A class");
  }
}

class B extends A {
  void helper() {
    System.out.println("B class");
  }
}


public class Polymorphism {  

   int add(int a, int b) {
    return a+b;
  }

   int add(int a,int b,int c) {
    return a+b+c;
  }
  public static void main(String args[]) {

    Polymorphism p = new Polymorphism();//used this as reason u can read by just using add sth related to static
     System.out.println(p.add(1,2));//compile time polymorphism
     System.out.println(p.add(1,2,3));//compile time polymorphism


     A objA = new A();//
     objA.helper();

     A objA1 = new B();//as A is parent of B
     objA1.helper();

    //  B obj1 = new A();// error 
  }

}
