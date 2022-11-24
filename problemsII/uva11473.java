import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

public class uva11473 {
    public static double EPS = 1E-9;
    public static Point CERO = new Point(0,0);

    public static class Point{
        double x;
        double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public static Point unit(Point a, Point b){
            return new Point((b.x-a.x)/dist(a,b),(b.y-a.y)/dist(a,b));
        }

        public static Point v(Point a, Point b,double D){
            return new Point(D*(b.x-a.x)/dist(a,b),D*(b.y-a.y)/dist(a,b));
        }

    }

    public static double dist(Point a, Point b){
        return Math.sqrt((b.x-a.x)*(b.x-a.x) + (b.y-a.y)*(b.y-a.y));
    }


    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for(int aux=1;aux<=N;aux++){

            System.out.println("Road #"+aux+":");
            int k = in.nextInt();
            double t = in.nextInt();

            Point[] puntos = new Point[k];

            double d = 0;

            for (int i = 0; i < k; i++) {
                puntos[i]=new Point(in.nextDouble(),in.nextDouble());
                if(i!=0){
                    d+=dist(puntos[i],puntos[i-1]);
                }
            }
            double seg = (d/(t-1));

            double recorrido=0;
            double queda=seg;
            int segact=1;
            Point actual=puntos[0];
            LinkedList<Point> l= new LinkedList<>();
            l.add(puntos[0]);
            while(recorrido<d){
                if(segact>=k)break;
                if(dist(actual,puntos[segact])<queda){
                    queda-=dist(actual,puntos[segact]);
                    recorrido+=dist(actual,puntos[segact]);
                    actual=puntos[segact];
                    segact++;
                }
                else{
                    Point v = Point.v(actual,puntos[segact],queda);
                    Point newt = new Point(actual.x+v.x,actual.y+v.y);
                    actual=newt;
                    l.add(newt);
                    recorrido+=queda;
                    queda=seg;

                }
            }
            if(l.size()<t)l.add(puntos[k-1]);
            DecimalFormat df = new DecimalFormat("##0.00");
            for (Point a : l) {
                System.out.println(df.format(a.x)+" "+df.format(a.y));
            }
            System.out.println();

        }
    }
}
