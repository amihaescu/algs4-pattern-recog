import java.awt.*;
import java.util.Arrays;

/**
 * Created by andrei on 7/22/14.
 */
public class Brute {

    private static void setUp(){
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.setPenColor(Color.black);
        StdDraw.setPenRadius(0.01);

    }

    private static Point[] getInput(String filename){
        In in = new In(filename);
        int n = in.readInt();
        Point[] points = new Point[n];

        for (int i = 0; i < n; i++){
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x,y);
            points[i].draw();
        }
        return points;
    }
    private static boolean distinctPoints(Point[] points){
        if (points.length != 4){
            throw new IllegalArgumentException("Method only works for 4-length arrays");
        }
        Point p1 = points[0];
        Point p2 = points[1];
        Point p3 = points[2];
        Point p4 = points[3];
        if ((!p1.equals(p2)) && (!p1.equals(p3))  && (!p1.equals(p4)) && (!p2.equals(p3)) &&
                (!p2.equals(p4)) && (!p3.equals(p4))){
            return true;
        }
        return false;
    }
    private static boolean equalSlopes(Point[] points){
        if (points.length != 4){
            throw new IllegalArgumentException("Method only works for 4-length arrays");
        }
        Point p1 = points[0];
        Point p2 = points[1];
        Point p3 = points[2];
        Point p4 = points[3];
        if ((p1.slopeTo(p2) == p1.slopeTo(p3)) && (p1.slopeTo(p3) == p1.slopeTo(p4))){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        setUp();
        Point[] points = getInput(args[0]);
        Arrays.sort(points);
        int size = points.length;
        for (int i = 0; i < size-3; i++){
            for (int j = i+1; j < size-2; j++){
                for (int k = j+1; k < size-1; k++){
                    for (int l = k+1; l < size; l++){
                        Point[] solutionPoints = new Point[4];
                        solutionPoints[0] = points[i];
                        solutionPoints[1] = points[j];
                        solutionPoints[2] = points[k];
                        solutionPoints[3] = points[l];
                        if (distinctPoints(solutionPoints))                        {
                            if (equalSlopes(solutionPoints)){
                                System.out.println(solutionPoints[0]+" -> "+solutionPoints[1]+" -> "+solutionPoints[2]+" -> "+
                                solutionPoints[3]);
                                solutionPoints[0].drawTo(solutionPoints[3]);
                            }
                        }
                    }
                }
            }
        }
    }
    }

