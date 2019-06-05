import org.junit.Assert;
import org.junit.Test;

public class TestBruteCollinearPoints {
    @Test
    public void testIllegalArgumentExceptionIfPointsNull() {
        //Arrange
        IllegalArgumentException actual = null;
        //Act
        try {
            BruteCollinearPoints bcp = new BruteCollinearPoints(null);
        }
        catch (IllegalArgumentException e) {
            actual = e;
        }
        //Assert
        Assert.assertNotNull(actual);
    }

    @Test
    public void testIllegalArgumentExceptionIfPointsIncludeNull() {
        //Arrange
        IllegalArgumentException actual = null;
        //Act
        try {
            Point[] points = {new Point(0, 1),
                    new Point(1, 2),
                    new Point(2, 3),
                    null};
            BruteCollinearPoints bcp = new BruteCollinearPoints(points);
        }
        catch (IllegalArgumentException e) {
            actual = e;
        }
        //Assert
        Assert.assertNotNull(actual);
    }

    @Test
    public void testIllegalArgumentExceptionIfPointsIncludeEqualPoints() {
        //Arrange
        IllegalArgumentException actual = null;
        //Act
        try {
            Point[] points = {new Point(0, 1),
                    new Point(1, 2),
                    new Point(2, 3),
                    new Point(2, 3)};
            BruteCollinearPoints bcp = new BruteCollinearPoints(points);
        }
        catch (IllegalArgumentException e) {
            actual = e;
        }
        //Assert
        Assert.assertNotNull(actual);
    }

    @Test
    public void testReturns01to34forOriginLineSegment() {
        //Arrange
        Point[] points = {new Point(0, 1),
                new Point(1, 2),
                new Point(2, 3),
                new Point(3, 4)};
        LineSegment expected = new LineSegment(new Point(0, 1), new Point(3, 4));
        //Act
        BruteCollinearPoints bcp = new BruteCollinearPoints(points);
        LineSegment actual = bcp.segments()[0];
        //Assert

        Assert.assertEquals(expected.toString(), actual.toString());
    }
}
