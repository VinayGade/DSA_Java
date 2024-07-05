package array.math;

/*
Segment A: p1, P2
P1(x1, y1) == (10, 0)
P2(x2, y2) == (0, 10)

Segment B: p3, P4
P3(x1, y1) == (10, 10)
P4(x2, y2) == (0, 0)

return true
Since segment A, B intersect with each other at P5(5, 5)

p1=(1,1), q1=(10,1), p2=(1,2), q2=(10,2)
return false
2 parallel lines never intersect each other.
*
* */

public class LineSegmentIntersection {

    // Custom class to represent a point in 2D space
    class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // Computes the direction of the three given points
    // Returns 0 if collinear, 1 if clockwise, 2 if counterclockwise
    // Computes the direction of the three given points
    // Returns 0 if collinear, 1 if clockwise, 2 if counterclockwise
    private int direction(Point p, Point q, Point r) {
        long val = (long)(q.y - p.y) * (r.x - q.x) - (long)(q.x - p.x) * (r.y - q.y);
        if (val == 0) return 0; // collinear
        return (val > 0) ? 1 : 2; // clock or counterclockwise
    }

    // Checks if point q lies on segment pr
    private boolean onSegment(Point p, Point q, Point r) {
        return (q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x) &&
                q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y));
    }

    // Checks if two line segments intersect
    private boolean isIntersect(Point a1, Point b1, Point a2, Point b2) {
        // Find the four orientations needed for general and special cases
        int d1 = direction(a1, b1, a2);
        int d2 = direction(a1, b1, b2);
        int d3 = direction(a2, b2, a1);
        int d4 = direction(a2, b2, b1);

        // General case
        return ((d1 != d2 && d3 != d4) ||

        // Special cases
        // a1, b1, a2 are collinear and a2 lies on segment a1b1
        (d1 == 0 && onSegment(a1, a2, b1)) ||

                // a1, b1, b2 are collinear and b2 lies on segment a1b1
                (d2 == 0 && onSegment(a1, b2, b1)) ||

                // a2, b2, a1 are collinear and a1 lies on segment a2b2
                (d3 == 0 && onSegment(a2, a1, b2)) ||

                // a2, b2, b1 are collinear and b1 lies on segment a2b2
                (d4 == 0 && onSegment(a2, b1, b2)));
    }

    String doIntersect(int p1[], int q1[], int p2[], int q2[]) {
        // Convert the integer arrays to Point objects
        Point a1 = new Point(p1[0], p1[1]);
        Point b1 = new Point(q1[0], q1[1]);
        Point a2 = new Point(p2[0], p2[1]);
        Point b2 = new Point(q2[0], q2[1]);

        // Check if the two line segments intersect or not
        return isIntersect(a1, b1, a2, b2) ? "true" : "false";
    }
}
