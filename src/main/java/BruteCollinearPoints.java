import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteCollinearPoints {
    private LineSegment[] segments;
    public BruteCollinearPoints(Point[] points)  {
        //Checking for null as professionals
        if (points == null) throw new IllegalArgumentException();
        int pointsNumber = points.length;
        List<LineSegment> segments = new ArrayList<LineSegment>();
        for (int i = 0; i< pointsNumber; i++) {
            //Checking for null as professionals

            Point firstPoint = points[i];
            if (firstPoint == null) throw new IllegalArgumentException();
            for (int j = i+1; j < pointsNumber; j++) {
                //Checking for null as professionals
                if (points[j] == null) throw new IllegalArgumentException();

                Point secondPoint = points[j];
                if (secondPoint.compareTo(firstPoint) == 0) throw new IllegalArgumentException();
                for (int k = j+1; k< pointsNumber; k++) {
                    //Checking for null as professionals
                    if (points[k] == null) throw new IllegalArgumentException();

                    Point thirdPoint = points[k];
                    if (thirdPoint.compareTo(firstPoint) == 0) throw new IllegalArgumentException();
                    if (thirdPoint.compareTo(secondPoint) == 0) throw new IllegalArgumentException();
                    for (int l = k + 1; l < pointsNumber; l++) {
                        //Checking for null as professionals
                        if (points[l] == null) throw new IllegalArgumentException();

                        Point fourthPoint = points[l];
                        if (fourthPoint.compareTo(firstPoint) == 0) throw new IllegalArgumentException();
                        if (fourthPoint.compareTo(secondPoint) == 0) throw new IllegalArgumentException();
                        if (fourthPoint.compareTo(thirdPoint) == 0) throw new IllegalArgumentException();

                        //Actual segment check
                        Point currentPoints[] ={firstPoint, secondPoint, thirdPoint, fourthPoint};
                        Arrays.sort(currentPoints, Point::compareTo);

                        if (currentPoints[0].slopeTo(currentPoints[1]) == currentPoints[1].slopeTo(currentPoints[2]) &&
                                currentPoints[1].slopeTo(currentPoints[2]) == currentPoints[2].slopeTo(currentPoints[3])) {
                            segments.add(new LineSegment(currentPoints[0], currentPoints[3]));
                        }
                    }
                }
            }
        }
        this.segments = segments.toArray(LineSegment[]::new);
    }   // finds all line segments containing 4 points
    public int numberOfSegments()        {
        return segments.length;
    }// the number of line segments
    public LineSegment[] segments() {
        return segments;
    }               // the line segments
}
