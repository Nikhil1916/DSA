// INHERITANCE
import java.util.*;

class Person {
  private int age;
  private String name;

  Person(String name, int age) {
    setAge(age);
    setName(name);
  }

  public String getName() {
    return this.name;
  }

  public int getAge() {
    return this.age;
  }

  public void setName(String n) {
    name = n;
  }

  public void setAge(int a) {
    age = a;
  }

  public String toString() {
    return (" "+this.name +" " + this.age);
  }
}


class StudentProfile extends Person {

  private int admissionId;

  StudentProfile(String name, int age, int admissionId) {
    super(name, age);
    this.admissionId = admissionId;
  }

  public int  getAdmissionId() {
    return this.admissionId;
  }

  public String toString() {
    return ("id --> "+this.admissionId + super.toString());
  }

}

class EmployeeProfile extends Person {
  private int employeeId;
  private int salary;
  EmployeeProfile(String name,int age,int id, int money) {
    super(name,age);
    this.employeeId = id;
    this.salary = money;
  }

  public getEmployeeId() {
    return this.employeeId;
  }

}

public class Main2 {
  public static void main(String args[]) {
    StudentProfile s = new StudentProfile("nikhil", 23, 1234);
    // s.setAge(25);
    System.out.println(s);
  }
}
