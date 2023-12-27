import java.util.ArrayList;
import java.util.Scanner;

public class uva634 {

    static double EPS = 1E-9;
    public static class Point {
        //Clase Para Points y vectores (Se utilizan ambos de manera identica)
        double x;
        double y;

        static double EPS = 1E-9;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
        public Point suma(Point t){return new Point(x+t.x,y+t.y);}
        public Point resta(Point t){return new Point(x-t.x,y-t.y);}
        public Point mul(double k){return new Point(x*k,y*k);}
        public Point div(double k){return new Point(x/k,y/k);}
        public double dot(Point t){return (x*t.x+y*t.y); } //Producto Escalar
        public double cross(Point t){return (x*t.y - y*t.x);}
        public double cross(Point a,Point b){return this.resta(a).cross(this.resta(b));}
        public double dist2(){ return x*x + y*y;}
        public double dist2(Point p){return this.resta(p).dist2();}
        public double dist(){return Math.sqrt(this.dist2());} //Modulo del vector
        public double dist(Point p){return Math.sqrt(this.dist2(p));}
        public double angle(){return Math.atan2(y, x);}
        boolean collinear(Point a, Point b){
            Point va = b.resta(a);
            Point vb = this.resta(a);
            if(va.x*vb.y==va.y*vb.x)return true;
            return false;
        }

        public Point unitario(){double l = this.dist(); return new Point(x/l,y/l);}
        public Point perp(){return new Point(this.y,-this.x);}

        //Rotacion de theta radianes respecto al origen en sentido contrario a las agujas del reloj
        public Point rot(double theta){return new Point(x*Math.cos(theta)-y*Math.sin(theta),x*Math.sin(theta)+y*Math.cos(theta));}

        //Determina si el punto de la clase esta a la izquierda de la recta definida por p y q
        public boolean ccw(Point p, Point q){
            Point vpq = p.resta(q);
            Point vpr = p.resta(this);
            double aux = vpq.cross(vpr);
            return aux>0;
        }
        // Proyeccion de this sobre v
        public Point proyec(Point v){
            double pe = this.dot(v);
            Point sol = v.unitario().mul(pe);
            return sol;
        }
        //Angulo entre p y q utilizando con this como vertice
        public double angle(Point p, Point q){
            Point vecop = p.resta(this);
            Point vecoq = q.resta(this);
            double a1 = vecop.dot(vecoq);
            double a2= vecop.dist()*vecoq.dist();
            double aux = Math.acos(a1/a2);
            return aux;
        }

        boolean onSegment(Point s, Point e){
            Point p = this;
            return p.cross(s,e)==0 && s.resta(p).dot(e.resta(p))<=0;
        }


        public int compareTo(Point other) {      // override less than operator
            if (Math.abs(x - other.x) > EPS)                // useful for sorting
                return (int)Math.ceil(x - other.x);       // first: by x-coordinate
            else if (Math.abs(y - other.y) > EPS)
                return (int)Math.ceil(y - other.y);      // second: by y-coordinate
            else
                return 0; }



    }

    public static boolean inPolygon(ArrayList<Point> pol, Point p){
        int n = pol.size();
        double sum=0;
        //if (p.onSegment(pol.get(0),pol.get(n-1))) return true;
        for(int i=0;i<n-1;i++){
            //if (p.onSegment(pol.get(i),pol.get(i+1))) return true;
            Point pi = pol.get(i);
            Point pi1 = pol.get(i+1);
            if(pi1.ccw(p,pi)) sum += p.angle(pi,pi1);
            else sum -= p.angle(pi,pi1);
        }
        Point pi = pol.get(n-1);
        Point pi1 = pol.get(0);
        if(pi1.ccw(p,pi)) sum += p.angle(pi,pi1);
        else sum -= p.angle(pi,pi1);
        return Math.abs(Math.abs(sum)-2*Math.PI)<EPS;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            if(n==0)break;
            ArrayList<Point> pol = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                pol.add(new Point(in.nextInt(),in.nextInt()));
            }
            if (inPolygon(pol, new Point(in.nextInt(),in.nextInt()))) System.out.println("T");
            else System.out.println("F");
        }

    }
}
