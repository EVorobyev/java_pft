package ru.stqa.pft.rest.tests;

import org.testng.annotations.Test;
/**
 * Created by EOnegin on 01.10.2017.
 */
public class IgnoredTests extends TestBase {

  private int id=5;

  @Test
  public void testIgnored(){
    skipIfNotFixed(id);
    System.out.println("Test is enabled");
  }

}
