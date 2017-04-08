/**
 * Created by obil on 08.04.17.
 */

class BruteCollinearPointsTest extends GroovyTestCase {

    Point p0_0 = new Point(0,0)
    Point p1_1 = new Point(1,1)
    Point p1_0 = new Point(1,0)
    Point p3_0 = new Point(3,0)
    Point p3_1 = new Point(3,1)
    Point p2_0 = new Point(2,0)
    Point p0_1 = new Point(0,1)

    void setUp() {
        super.setUp()
    }

    void tearDown() {
    }

    void testIsCollinear() {
        BruteCollinearPoints b = new BruteCollinearPoints(new Point[0]);
        assert !b.isCollinear(p0_0,p1_0,p2_0,p1_1)
        assert b.isCollinear(p0_0,p1_0,p2_0,p3_0)

        Point p1 = new Point(0,0);
        Point p2 = new Point(1,0);
        Point p3 = new Point(2,0);
        Point p4 = new Point(3,1);

        Comparator<Point> comp = p1.slopeOrder();
        println  "comp.compare(p2, p3)${comp.compare(p2, p4)}"
        assert 0 == comp.compare(p2, p3)
        println "comp.compare(p2, p4)${comp.compare(p2, p4)}"
        assert comp.compare(p2, p4) != 0

        assert !b.isCollinear(
                p1,
                p2,
                p3,
                p4)




    }
}
