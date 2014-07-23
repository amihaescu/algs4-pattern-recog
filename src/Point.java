/*************************************************************************
 * Name:
 * Email:
 *
 * Compilation:  javac Point.java
 * Execution:
 * Dependencies: StdDraw.java
 *
 * Description: An immutable data type for points in the plane.
 *
 *************************************************************************/

import java.lang.Override;
import java.util.Comparator;

public class Point implements Comparable<Point> {

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = new BySlope();       // YOUR DEFINITION HERE

    private class BySlope implements Comparator<Point>{

        @Override
        public int compare(Point o1, Point o2) {
            double s1 = Point.this.slopeTo(o1);
            double s2 = Point.this.slopeTo(o2);
            if (s1 < s2){
                return -1;
            }else if (s1 > s2) {
                return 1;
            }
            return 0;
        }
    }

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate

    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
        /* YOUR CODE HERE */
        if (this.y == that.y){
            if (this.x == that.x){
                return Double.NEGATIVE_INFINITY;
            }
            return 0.00;
        }
        if (this.x == that.x){
            return Double.POSITIVE_INFINITY;
        }

        double slope = (double)(that.y - this.y)/(double)(that.x - this.x);
        return slope;

    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {
        /* YOUR CODE HERE */
        if (this.y < that.y){
            return -1;
        }else if (this.y > that.y){
            return 1;
        }else{
            if (this.x < that.x){
                return -1;
            }else if (this.x > that.x){
                return 1;
            }
        }
        return 0;
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    // unit test
    public static void main(String[] args) {
        /* YOUR CODE HERE */
        Point p_ref = new Point(1,1);
        Point p = new Point(229,113);
        Point q = new Point(134,382);
        System.out.println("Slope from "+p+" to "+q+" is "+p.slopeTo(q));
        //System.out.println(p1.compareTo(p2));
        //System.out.print(p_ref.SLOPE_ORDER.compare(p2,p1));

    }
}
