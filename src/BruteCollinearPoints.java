import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by obil on 06.04.17.
 */

public class BruteCollinearPoints {


    private  int numOfSeg = 0;
    private LineSegment[] lineSeg = new LineSegment[0];

    private void addSeg (LineSegment seg) {
        if (lineSeg.length == numOfSeg) {
            LineSegment[] newLineSeg = new LineSegment[numOfSeg+1];
            for (int i = 0; i <= numOfSeg-1; i++) {
                newLineSeg[i] = lineSeg[i];
            }
            lineSeg = newLineSeg;
        }

        lineSeg[numOfSeg++] = seg;

    }

    public BruteCollinearPoints(Point[] points)    // finds all line segments containing 4 points
    {
        if (points == null) throw new java.lang.NullPointerException();

        for (Point p : points) if (p == null) throw new java.lang.NullPointerException();

        Arrays.sort(points,Point.NORM_COMPARATOR);

        for (int i = 1; i < points.length; i++)  if (points[i].compareTo(points[i-1]) == 0) throw new java.lang.IllegalArgumentException();

        // this.points = points;

        //бежим в четверном цикле, перебирая все четверки
        Comparator<Point> cp;
        for (int i = 0; i < points.length; i++) {
            cp = points[i].slopeOrder();
            for (int j = i + 1; j < points.length; j++)
                for (int k = j + 1; k < points.length; k++)
                    for (int l = k + 1; l < points.length; l++) {
                        if (cp.compare(points[j], points[k]) == 0
                                && cp.compare(points[j], points[l]) == 0) {
                            addSeg(new LineSegment(points[i], points[l]));
                        }

                    }
        }

    }

    public boolean isCollinear(Point p1, Point p2, Point p3, Point p4) {
        Comparator<Point> comp = p1.slopeOrder();
        return (comp.compare(p2,p3) == 0 && comp.compare(p2, p4) == 0);
    }


    public int numberOfSegments()        // the number of line segments
    {
        return numOfSeg;
    }

    public LineSegment[] segments()                // the line segments
    {
        return lineSeg;
    }

    public static void main(String[] args) {
        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();
        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        StdOut.println("num="+collinear.numberOfSegments());
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
