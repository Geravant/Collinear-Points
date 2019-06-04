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
}
