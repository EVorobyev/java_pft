package ru.stqa.pft.sandbox;

/**
 * Created by EOnegin on 15.07.2017.
 */
public class DistanceCalculation {

  public static void main(String[] args){
    Point p1 = new Point();
    p1.x = 3;
    p1.y = 6;

    Point p2 = new Point();
    p2.x = 5;
    p2.y = 9;
    System.out.println ("Расстояние на координатной оси между точками c координатами " + "(" + p1.x + ", "+ p1.y + ")" + " и " + "(" + p2.x + ", " + p2.y + ")" + " = " + p2.distance(p1));
  }
}
