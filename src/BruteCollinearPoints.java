import java.util.Arrays;

/**
 * Created by obil on 06.04.17.
 */
public class BruteCollinearPoints {
    // private Point[] points;
    public BruteCollinearPoints(Point[] points)    // finds all line segments containing 4 points
    {
        if (points == null) throw new java.lang.NullPointerException();

        for (Point p : points) if (p == null) throw new java.lang.NullPointerException();

        Arrays.sort(points,Point.NORM_COMPARATOR);

        for (int i = 1; i < points.length; i++)  if (points[i].compareTo(points[i-1]) == 0) throw new java.lang.IllegalArgumentException();

        // this.points = points;

        //бежим в четверном цикле, перебирая все четверки
        for (int i = 0; i < points.length; i++)
            for (int j = i + 1; j < points.length; j++)
                for (int k = j + 1; k < points.length; k++)
                    for (int l = k + 1; l < points.length; l++) {
                        if (points[i].slopeOrder().compare(points[j],points[k]) == 0
                                &&  points[i].slopeOrder().compare(points[j],points[l]) == 0)
                        {

                        }

                    }

    }

    public int numberOfSegments()        // the number of line segments
    {
        return 0;
    }

    public LineSegment[] segments()                // the line segments
    {
        return null;
    }
}
