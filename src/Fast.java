import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by andrei on 7/22/14.
 */
public class Fast {
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
    public static void main(String[] args){
        ArrayList<Point> coll = new ArrayList<Point>();
        ArrayList<Point> prevColl = new ArrayList<Point>();
        setUp();
        Point[] points = getInput("input8.txt");
        int size = points.length;
        for (int i = 0; i < size - 1; i++){
            Point origin = points[i];
            Arrays.sort(points, i+1,size,origin.SLOPE_ORDER);

            int step = 1;

            for (int j = i+1; j < size; j+=step){

                coll.clear();

                coll.add(origin);
                coll.add(points[j]);

                while ((j +step < size) && (origin.SLOPE_ORDER.compare(points[j],points[j+step])==0)){
                    coll.add(points[j+step]);
                    step++;
                }
                coll.removeAll(prevColl);
                if (coll.size()>3){
                    Collections.sort(coll);
                    for (int k = 0; k < coll.size();k++){
                        if (k == coll.size() -1){
                            System.out.print(coll.get(k));
                            coll.get(0).drawTo(coll.get(k));
                        }else {
                            System.out.print(coll.get(k) + " -> ");
                        }

                    }
                    for (Point p:coll){
                        prevColl.add(p);
                    }
                    System.out.println();

                }

            }
        }

    }
}

