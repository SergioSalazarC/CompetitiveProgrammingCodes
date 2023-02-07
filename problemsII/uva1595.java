import java.util.*;

public class uva1595 {

    public static class Point implements Comparable{
        double x;
        double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Object o) {
            Point i = (Point) o;
            return Double.compare(this.x,i.x);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        while(n-->0){

            int cant_points = in.nextInt();
            ArrayList<Point> al = new ArrayList<>();
            HashSet<Point> hs = new HashSet<>();

            for (int i = 0; i < cant_points; i++) {
                Point p = new Point(in.nextDouble(),in.nextDouble());
                al.add(p);
                hs.add(p);
            }

            Collections.sort(al);

            if(cant_points%2==0){
                int t = cant_points/2;
                Point mid1 = al.get(t-1);
                Point mid2 = al.get(t);

                double r = (mid1.x+mid2.x)/2.0;
                boolean flag = true;

                for (int i = 0; i <= t; i++) {
                    Point aux = al.get(i);
                    Point sim = new Point(r+(r-aux.x),aux.y);

                    if(!hs.contains(sim)){
                        flag=false;
                        break;
                    }

                }
                if(flag) System.out.println("YES");
                else System.out.println("NO");



            }
            else{
                int t = cant_points/2;
                Point mid = al.get(t);
                //La recta es x = mid.x

                double r = mid.x;
                boolean flag = true;

                for (int i = 0; i <= t; i++) {
                    Point aux = al.get(i);
                    Point sim = new Point(r+(r-aux.x),aux.y);

                    if(!hs.contains(sim)){
                        flag=false;
                        break;
                    }

                }
                if(flag) System.out.println("YES");
                else System.out.println("NO");

            }


        }


    }
}
