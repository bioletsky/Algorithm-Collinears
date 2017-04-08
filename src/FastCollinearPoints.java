import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by obil on 08.04.17.
 */
public class FastCollinearPoints {

    private  int numOfSeg = 0;
    private LineSegment[] lineSeg = new LineSegment[1];

    private void addSeg (LineSegment seg) {
        if (lineSeg.length == numOfSeg) {
            LineSegment[] newLineSeg = new LineSegment[numOfSeg*2];
            for (int i = 0; i <= numOfSeg-1; i++) {
                newLineSeg[i] = lineSeg[i];
            }
            lineSeg = newLineSeg;
        }

        lineSeg[numOfSeg++] = seg;
    }

    public FastCollinearPoints(Point[] points)     // finds all line segments containing 4 or more points
    {
        if (points == null) throw new java.lang.NullPointerException();

        for (Point p : points) if (p == null) throw new java.lang.NullPointerException();

        Arrays.sort(points,Point.NORM_COMPARATOR);

        for (int i = 1; i < points.length; i++)  if (points[i].compareTo(points[i-1]) == 0) throw new java.lang.IllegalArgumentException();

        if (points.length <=3) return;

        Point [] otherPoints = new Point[points.length-1];
        for (int i = 0; i < points.length; i++) {
            //create array of slopes
            //sort in and search
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                otherPoints[j < i ? j : j-1] = points[j];
            }
            Arrays.sort(otherPoints,points[i].slopeOrder());
            int j1=0; //begin of equal token
            for (int j = 1; j < otherPoints.length ; j++) {
                if ((points[i].slopeTo(otherPoints[j]) != points[i].slopeTo(otherPoints[j1]))
                        && ((j-j1+1) >= 4)) {
                    addSeg( new LineSegment());
                }
            }
        }

    }
    public int numberOfSegments()        // the number of line segments
    {
        return numOfSeg;
    }

    public LineSegment[] segments()                // the line segments
    {
        if (lineSeg.length != numOfSeg) {
            LineSegment[] newLineSeg = new LineSegment[numOfSeg];
            for (int i = 0; i <= numOfSeg-1; i++)
                newLineSeg[i] = lineSeg[i];
            lineSeg = newLineSeg;

        }
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

