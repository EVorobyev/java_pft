package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by EOnegin on 15.07.2017.
 */
public class DistanceTests {

  @Test
  public void testDistanceCalculations1() {
    Point p1 = new Point();
    p1.x = 3;
    p1.y = 6;

    Point p2 = new Point();
    p2.x = 5;
    p2.y = 9;

    Assert.assertEquals(p2.distance(p1), 3.605551275463989);
  }

  @Test
  public void testDistanceCalculations2() {
    Point p1 = new Point();
    p1.x = 1;
    p1.y = 4;

    Point p2 = new Point();
    p2.x = 7;
    p2.y = 8;

    Assert.assertEquals(p2.distance(p1), 7.211102550927978);
  }

  @Test
  public void testDistanceCalculations3() {
    Point p1 = new Point();
    p1.x = 2;
    p1.y = 3;

    Point p2 = new Point();
    p2.x = 8;
    p2.y = 9;

    Assert.assertEquals(p2.distance(p1), 8.48528137423857);
  }
}