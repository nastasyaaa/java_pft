package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft2.sandbox.Point;

public class PointTests {
@Test
    public void testArea(){
    Point first = new Point(5,2);
    Point second = new Point(9,2);
        Assert.assertEquals(first.distance(second),4.0);

    }
}
