import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FastCollinearPoints {
    private LineSegment[] segments;
    public FastCollinearPoints(Point[] points)    {
        //Checking for null as professionals
        if (points == null) throw new IllegalArgumentException();
        int pointsNumber = points.length;
        List<LineSegment> segments = new ArrayList<LineSegment>();
        for (int i = 0; i< pointsNumber; i++) {
            if (points[i] == null) throw new IllegalArgumentException();
            Point origin = points[i];
            Point[] pointsToCompare = new Point[pointsNumber - 1];
            int k = 0;
            for (int j = 0; j< pointsNumber; j ++) {
                if (i == j) continue;
                if (points[j] == null) throw new IllegalArgumentException();
                Point currentPoint = points[j];
                if (currentPoint.compareTo(origin) == 0) throw new IllegalArgumentException();
                pointsToCompare[k] = currentPoint;
                k++;
            }
            Arrays.sort(pointsToCompare, new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    if (o1.slopeTo(origin) > o2.slopeTo(origin)) return 1;
                    else if (o1.slopeTo(origin) < o2.slopeTo(origin)) return -1;
                    else return 0;
                }
            });
            for (int j = 0; j < pointsToCompare.length; j++) {
                int l = 1;
                while (l + j - 1 < pointsToCompare.length) {
                    if (pointsToCompare[j+l - 1].slopeTo(origin) != pointsToCompare[j].slopeTo(origin)) break;
                    l++;
                }
                if (l >= 4) {
                    segments.add(new LineSegment(origin, pointsToCompare[j + l - 1]));
                }
            }
        }
        this.segments = segments.toArray(LineSegment[]::new);
    }  // finds all line segments containing 4 or more points
    public int numberOfSegments()  {
        return segments.length;
    }      // the number of line segments
    public LineSegment[] segments() {
        return segments;
    }               // the line segments
}
