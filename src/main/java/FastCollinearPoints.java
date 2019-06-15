import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FastCollinearPoints {
    private LineSegment[] segments;

    private List<LineSegment> compareSlopesToAnOrigin(Point origin, Point[] pointsToCompare) {

        List<LineSegment> segments = new ArrayList<LineSegment>();
        int segmentLength = 1;
        if (pointsToCompare.length >= 3) {
            if (pointsToCompare[0].compareTo(origin)>0) {
                for (int j = 1; j < pointsToCompare.length; j++) {
                    if (pointsToCompare[j-1].slopeTo(origin) != pointsToCompare[j].slopeTo(origin)) {
                        break;
                    }
                    segmentLength++;
                }
                if (segmentLength >= 3) {
                    segments.add(new LineSegment(origin, pointsToCompare[segmentLength-1]));
                }}
        }
        return  segments;
    }
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
            Arrays.sort(pointsToCompare, origin.slopeOrder());
            segments.addAll(compareSlopesToAnOrigin(origin, pointsToCompare));

        }
        int segmentsAmount = segments.size();
        this.segments = new LineSegment[segmentsAmount];
        for (int i = 0; i< segmentsAmount; i++) {
            this.segments[i] = segments.get(i);
        }
    }  // finds all line segments containing 4 or more points
    public int numberOfSegments()  {
        return segments.length;
    }      // the number of line segments
    public LineSegment[] segments() {
        return segments;
    }               // the line segments
}
