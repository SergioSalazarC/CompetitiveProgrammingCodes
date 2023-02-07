import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class uva10927 {
    static ArrayList<Point2> unac;

    public static int eval(ArrayList<Point> al){
        int sol=0;
        long max=-1;
        for (int i = 0; i < al.size(); i++) {
            Point k = al.get(i);
            if(k.z>max){
                max=k.z;
                sol++;
            }
            else{
                unac.add(new Point2(k.x,k.y));
            }
        }
        return sol;
    }

    public static double dist(Point p){
        return Math.sqrt(Math.pow(p.x,2) + Math.pow(p.y,2));
    }

    public static class Point2 implements Comparable{
        long x;
        long y;


        public Point2(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Object o) {
            Point2 i = (Point2) o;

            if(i.x==this.x) return (int) (this.y-i.y);
            else return (int) (this.x-i.x);
        }

        @Override
        public String toString() {
            return "x = "+this.x+", y = "+this.y;
        }
    }



    public static class Point implements Comparable{
        long x;
        long y;
        long z;

        public Point(long x, long y, long z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public int compareTo(Object o) {
            Point i = (Point) o;

            double anglet = Math.atan2(this.y,this.x);
            double anglei = Math.atan2(i.y,i.x);

            if(anglet==anglei){
                if(dist(this)<dist(i)) return -1;
                else return 1;
            }

            if(anglet<anglei)return -1;
            else return 1;

        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int caso=1;
        int n = in.nextInt();
        while(n!=0){
            unac = new ArrayList<Point2>();
            ArrayList<Point> al = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Point p = new Point(in.nextInt(),in.nextInt(),in.nextInt());
                al.add(p);
            }

            Collections.sort(al);

            ArrayList<Point> mid = new ArrayList<>();
            int sol = 0;

            for (int i = 0; i < al.size(); i++) {

                if(i==al.size()-1){
                    Point tal = al.get(i);
                    mid.add(tal);
                    sol+=eval(mid);
                    break;
                }
                else{
                    Point tal = al.get(i);
                    Point next= al.get(i+1);

                    mid.add(tal);

                    if(Math.atan2(tal.y,tal.x) != Math.atan2(next.y, next.x)){
                        sol+=eval(mid);
                        mid= new ArrayList<>();
                    }
                }
            }

            System.out.println("Data set "+caso+":");
            caso++;

            if(sol==n) System.out.println("All the lights are visible.");

            else{
                System.out.println("Some lights are not visible:");
                Collections.sort(unac);
                for (int i = 0; i < unac.size(); i++) {
                    System.out.print(unac.get(i));
                    if(i!= unac.size()-1) System.out.println(";");
                    else System.out.println(".");
                }

            }

            n= in.nextInt();
        }





    }
}
