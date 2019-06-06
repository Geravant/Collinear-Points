import org.junit.Assert;
import org.junit.Test;

public class TestPoint {

    @Test
    public void testCompareToReturns0ForEqualPoints() {
        //Arrange
        Point point1 = new Point(0,0);
        Point point2 = new Point(0,0);
        int expected = 0;
        //Act
        int actual = point1.compareTo(point2);
        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCompareToReturns0ForItself() {
        //Arrange
        Point point1 = new Point(0,0);
        int expected = 0;
        //Act
        int actual = point1.compareTo(point1);
        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCompareToReturns1ForLesserYPoint() {
        //Arrange
        Point point1 = new Point(0,0);
        Point point2 = new Point(0,-1);
        int expected = 1;
        //Act
        int actual = point1.compareTo(point2);
        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCompareToReturnsNegative1ForGreaterYPoint() {
        //Arrange
        Point point1 = new Point(0,0);
        Point point2 = new Point(0,1);
        int expected = -1;
        //Act
        int actual = point1.compareTo(point2);
        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCompareToReturns1ForLesserXPointWithEqualY() {
        //Arrange
        Point point1 = new Point(0,0);
        Point point2 = new Point(-1, 0);
        int expected = 1;
        //Act
        int actual = point1.compareTo(point2);
        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCompareToReturns1ForGreaterXPointWithEqualY() {
        //Arrange
        Point point1 = new Point(1,0);
        Point point2 = new Point(0, 0);
        int expected = 1;
        //Act
        int actual = point1.compareTo(point2);
        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSLopeToReturns1For11AndOrigin() {
        //Arrange
        Point point1 = new Point(0,0);
        Point point2 = new Point(1, 1);
        double expected = 1;
        //Act
        double actual = point1.slopeTo(point2);
        //Assert
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testSLopeToReturns2For12AndOrigin() {
        //Arrange
        Point point1 = new Point(0,0);
        Point point2 = new Point(1, 2);
        double expected = 2;
        //Act
        double actual = point1.slopeTo(point2);
        //Assert
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testSLopeToReturns0For12And02() {
        //Arrange
        Point point1 = new Point(0,2);
        Point point2 = new Point(1, 2);
        double expected = 0;
        //Act
        double actual = point1.slopeTo(point2);
        //Assert
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testSLopeToReturnsNegativeInfinityFor11And11() {
        //Arrange
        Point point1 = new Point(1,1);
        Point point2 = new Point(1, 1);
        double expected = Double.NEGATIVE_INFINITY;
        //Act
        double actual = point1.slopeTo(point2);
        //Assert
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testSLopeToReturnsPositiveInfinityFor10And11() {
        //Arrange
        Point point1 = new Point(1,0);
        Point point2 = new Point(1, 1);
        double expected = Double.POSITIVE_INFINITY;
        //Act
        double actual = point1.slopeTo(point2);
        //Assert
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testSLopeToReturnsNegative1AndAHalfFor43And26() {
        //Arrange
        Point point1 = new Point(4,3);
        Point point2 = new Point(2, 6);
        double expected = -1.5;
        //Act
        double actual = point1.slopeTo(point2);
        //Assert
        Assert.assertEquals(expected, actual, 0.01);
    }
}
