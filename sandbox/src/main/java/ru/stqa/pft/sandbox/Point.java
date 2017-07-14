package ru.stqa.pft.sandbox;

/**
 * Created by EOnegin on 14.07.2017.
 */
public class Point {

  public double x;
  public double y;

  public double distance(Point p1){
    double dx = this.x - p1.x;
    double dy = this.y - p1.y;
    return Math.sqrt(dx * dx + dy * dy);
  }

}
