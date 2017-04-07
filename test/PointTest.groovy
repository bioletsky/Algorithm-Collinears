/**
 * Created by obil on 07.04.17.
 */
class PointTest extends GroovyTestCase {

    void testSlopeTo() {

        //slope v1 v2 - tg (v2-v1)
       //and check corner cases
        Point p0_0 = new Point(0,0);
        Point p1_1 = new Point(1,1);
        Point p1_0 = new Point(1,0);
        Point p0_1 = new Point(0,1);
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

    }

    void testCompareTo() {
    }

    void testSlopeOrder() {
    }
}

