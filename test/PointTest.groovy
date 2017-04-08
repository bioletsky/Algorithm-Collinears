/**
 * Created by obil on 07.04.17.
 */

class PointTest extends GroovyTestCase {
    Point p0_0 = new Point(0,0)
    Point p1_1 = new Point(1,1)
    Point p1_0 = new Point(1,0)
    Point p3_0 = new Point(3,0)
    Point p2_0 = new Point(2,0)
    Point p0_1 = new Point(0,1)
    Point p3_1 = new Point(3,1)

    void testSlopeTo() {

        //slope v1 v2 - tg (v2-v1)
       //and check corner cases

        assert p0_0.slopeTo(p1_1) == 1
        assert p1_1.slopeTo(p0_0) == 1
        assert p0_0.slopeTo(p0_0) == Double.NEGATIVE_INFINITY
        assert p1_1.slopeTo(p1_1) == Double.NEGATIVE_INFINITY
        assert p1_0.slopeTo(p0_1) == -1
        assert p0_0.slopeTo(p1_0) == +0.0
        assert p1_0.slopeTo(p0_0) == +0.0
        assert p1_0.slopeTo(p1_1) == Double.POSITIVE_INFINITY
        assert p1_1.slopeTo(p1_0) == Double.POSITIVE_INFINITY
        assert p0_0.slopeTo(p0_1) == Double.POSITIVE_INFINITY
        assert p0_1.slopeTo(p0_0) == Double.POSITIVE_INFINITY

        /*
        double slopeThisP1 = Point.this.slopeTo(p1);
        double slopeThisP2 = Point.this.slopeTo(p2);
        if (slopeThisP1 < slopeThisP2) return -1;
        if (slopeThisP1 > slopeThisP2) return 1;
        return 0;
        */
        assert p0_0.slopeTo(p1_0) == 0
        println "p0_0.slopeTo(p3_1)${p0_0.slopeTo(p3_1)}"
        assert p0_0.slopeTo(p3_1) > 0

    }

    void testCompareTo() {
        assert p0_0.compareTo(p1_1) == -1
        assert p1_1.compareTo(p0_0) == 1
        assert p0_0.compareTo(p0_0) == 0
        assert p1_1.compareTo(p1_1) == 0
        assert p1_1.compareTo(p1_0) == 1
        assert p1_1.compareTo(p0_1) == 1

    }

    void testSlopeOrder() {

        Comparator<Point> c = p0_0.slopeOrder();
        assert c.compare(p1_0,p1_1) == -1
        assert c.compare(p1_1,p1_0) ==  1
        assert c.compare(p1_1,p1_1) ==  0
        assert c.compare(p0_0,p0_0) ==  0

        assert c.compare(p1_0,p2_0) ==  0
        assert c.compare(p1_0,p3_0) ==  0
        assert c.compare(p1_0,p1_1) ==  -1
        assert c.compare(p1_0,p3_1) ==  -1


    }
}

