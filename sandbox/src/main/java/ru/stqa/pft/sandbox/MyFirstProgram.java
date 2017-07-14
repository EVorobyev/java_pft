package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");
    hello("everybody");
    hello("Evgeniy my friend");

    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4, 6);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

    Point p1 = new Point();
    p1.x = 3;
    p1.y = 6;

    Point p2 = new Point();
    p2.x = 5;
    p2.y = 9;
    System.out.println ("Расстояние на координатной оси между точками c координатами " + p1.x + ";"+ p1.y + " и " + p2.x + ";"+ p2.y + " = " + distance(p1, p2));
  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }

  public static double distance(Point p1, Point p2){
    double dx = p2.x - p1.x;
    double dy = p2.y - p1.y;
    return Math.sqrt(dx * dx + dy * dy);
  }

}