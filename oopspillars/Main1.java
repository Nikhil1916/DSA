// package oopspillars;

// ABSTRACTION
interface Shape {
  public int area();
}

class Square implements Shape {
  private int side = 10;
  public int area() {
    return this.calculateArea();
  }

  private int calculateArea() {
    return side * side;
  }
}

class Rectangle implements Shape {
  private int length = 10;
  private int width = 20;
  public int area() {
    return this.calculateArea();
  }

  private int calculateArea() {
    return this.length * this.width;
  }
}

public class Main1 {
 
  static Shape factory(String type) {
    if(type == "square") {
      return new Square();
    } else if(type == "rectangle") {
      return new Rectangle();
    }
    return null;
  }
  public static void main(String args[]) {
    // Square sq = new Square();
    Shape obj = factory("rectangle");
    System.out.println(obj.area());
  }
  
}
