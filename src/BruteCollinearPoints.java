import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by obil on 06.04.17.
 */
public class BruteCollinearPoints {
    // private Point[] points;

    private  int numOfSeg = 0;
    private Node first = null;

    private class Node {
        private LineSegment item;
        private Node next;
        public Node(LineSegment item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    private void addSeg (LineSegment seg) {
        Node item;
        item = new Node(seg, first);
        first = item;
        numOfSeg++;
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


    public int numberOfSegments()        // the number of line segments
    {
        return numOfSeg;
    }

    public LineSegment[] segments()                // the line segments
    {
        return null;
    }
}
