import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class uva191ast {

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
        //Aangulo entre p y q utilizando el punto de la clase como vertice
        public double angle(Point p, Point q){
            Point vecop = p.resta(this);
            Point vecoq = q.resta(this);
            double a1 = vecop.dot(vecoq);
            double a2= vecop.dist()*vecoq.dist();
            double aux = Math.acos(a1/a2);
            return aux;
        }
        //Interseccion de la recta que pasa por AB con el segmento pq.
        //Resultado no definido si no interseca.
        static Point lineIntersec(Point p, Point q, Point A, Point B){
            double a=B.y-A.y;
            double b=A.x-B.x;
            double c=B.x*A.y-A.x*B.y;
            double u=Math.abs(a*p.x+b*p.y+c);
            double v=Math.abs(a*q.x+b*q.y+c);
            return new Point((p.x*v+q.x*u)/(u+v), (p.y*v+q.y*u)/(u+v));
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
    public static class Polygon {
        static double EPS=1E-9;
        ArrayList<Point> pol;

        public Polygon(ArrayList<Point> pol) {
            this.pol = pol;
        }

        @Override
        public String toString() {
            String k="";
            for(Point p : pol){
                k+="("+p.x+","+p.y+") _ ";
            }
            return k;
        }
        //Tested: No
        double perimeter(){
            double P = 0;
            for(int i=0;i<pol.size()-1;i++){
                Point aux = pol.get(i);
                P+= aux.dist(pol.get(i+1));
            }
            P+=pol.get(0).dist(pol.get(pol.size()-1));
            return P;
        }

        //Tested: uva11447
        double area(){
            double res=0;
            for(int i=0;i<pol.size();i++){
                Point p = (i!=0 ? pol.get(i-1) : pol.get(pol.size()-1) );
                Point q = pol.get(i);
                res+=(p.x-q.x)*(p.y+q.y);
            }
            res= Math.abs(res/2);
            return res;
        }

        //Tested: by hand
        boolean isConvex(){
            int n = pol.size();
            if(n<3) return false;
            boolean isLeft = pol.get(0).ccw(pol.get(n-2),pol.get(n-1));
            for(int i=0;i<pol.size()-2;i++){
                if(pol.get(i+2).ccw(pol.get(i),pol.get(i+1))!=isLeft) return false;
            }
            if(pol.get(1).ccw(pol.get(n-1),pol.get(0))!=isLeft) return false;
            return true;
        }

        //Tested: No
        Point polygonCenter(){
            Point p = new Point(0,0);
            double A = 0;
            for(int i=0,j=pol.size()-1;i<pol.size();j=i++){
                Point pj = pol.get(j);
                Point pi = pol.get(i);
                p = p.suma(pi.suma(pj)).mul(pj.cross(pj,pi));
                A+= pj.cross(pi);
            }
            return (p.div(A).div(3));
        }

        //Tested: uva10112
        //Devuelve cierto si un punto esta en el interior estricto del poligono, descomentar para los bordes
        boolean inPolygon(Point p){
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

        //Tested: by hand
        //obtenemos la parte izquierda del poligono intersecado por la recta que pasa por a y b
        //Si queremos la parte derecha basta cambiar a b por b a.
        Polygon cutPolygon(Point a, Point b){
            int n = pol.size();
            ArrayList<Point> P=new ArrayList<>();
            for(int i=0;i<n-1;i++){
                double left1= b.resta(a).cross(pol.get(i).resta(a));
                double left2= 0;
                if(i!=n-1) left2=b.resta(a).cross(pol.get(i+1).resta(a));
                if(left1 > -EPS) P.add(pol.get(i));
                if(left1*left2 < -EPS) P.add(Point.lineIntersec(pol.get(i),pol.get(i+1),a,b));
            }
            double left1= b.resta(a).cross(pol.get(n-1).resta(a));
            double left2= b.resta(a).cross(pol.get(0).resta(a));
            if(left1 > -EPS) P.add(pol.get(n-1));
            if(left1*left2 < -EPS) P.add(Point.lineIntersec(pol.get(n-1),pol.get(0),a,b));
            return new Polygon(P);
        }


        static Polygon convexHull(ArrayList<Point> P) {
            Point pivot;
            int i, j, n = (int)P.size();
            if (n <= 3) {
                if (P.get(0).compareTo(P.get(n-1)) != 0) P.add(P.get(0)); // safeguard from corner case
                return new Polygon(P); // special case, the CH is P itself
            }

            // first, find P0 = point with lowest Y and if tie: rightmost X
            int P0 = 0;
            for (i = 1; i < n; i++)
                if (P.get(i).y  < P.get(P0).y ||
                        (P.get(i).y == P.get(P0).y && P.get(i).x > P.get(P0).x))
                    P0 = i;

            Point temp = P.get(0); P.set(0, P.get(P0)); P.set(P0 ,temp); // swap P[P0] with P[0]

            // second, sort points by angle w.r.t. P0
            pivot = P.get(0); // use this global variable as reference
            Collections.sort(P, new Comparator<Point>(){
                public int compare(Point a, Point b) { // angle-sorting function
                    if (pivot.collinear( a, b))
                        return a.dist(pivot) < b.dist(pivot) ? -1 : 1; // which one is closer?
                    double d1x = a.x - pivot.x, d1y = a.y - pivot.y;
                    double d2x = b.x - pivot.x, d2y = b.y - pivot.y;
                    return (Math.atan2(d1y, d1x) - Math.atan2(d2y, d2x)) < 0 ? -1 : 1;
                }
            });

            // third, the ccw tests
            ArrayList<Point> S = new ArrayList<>();
            S.add(P.get(n-1)); S.add(P.get(0)); S.add(P.get(1)); // initial S
            i = 2; // then, we check the rest
            while (i < n) { // note: n must be >= 3 for this method to work
                j = S.size() - 1;
                if (P.get(i).ccw(S.get(j-1), S.get(j))) S.add(P.get(i++)); // left turn, accept
                else S.remove(S.size() - 1); // or pop the top of S until we have a left turn
            }
            return new Polygon(S); }

    }

    public static boolean pertenece(Point a, Point b, Point c){
        if(a.x==b.x){
            if(a.x==c.x && ((a.y<=c.y && c.y<=b.y) || (b.y<=c.y && c.y<=a.y))) return true;
        }
        else{
            double m =(a.y-b.y)/(a.x-b.x);
            double n = a.y-m*a.x;
            if(c.y == m*c.x+n){
                double xm=Math.min(a.x,b.x);
                double xM=Math.max(a.x,b.x);
                double ym=Math.min(a.y,b.y);
                double yM=Math.max(a.y,b.y);

                if(xm<=c.x && c.x<=xM && ym <= c.y && c.y<=yM){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0){
            double xstart = in.nextDouble();
            double ystart=in.nextDouble();
            double xend = in.nextDouble();
            double yend = in.nextDouble();
            Point a = new Point(xstart,ystart);
            Point b = new Point(xend,yend);

            ArrayList<Point> p = new ArrayList<>();


            double xleft = in.nextDouble();
            double ytop = in.nextDouble();
            double xright = in.nextDouble();
            double ybottom = in.nextDouble();
            p.add(new Point(xleft,ytop));
            p.add(new Point(xright,ytop));
            p.add(new Point(xright,ybottom));
            p.add(new Point(xleft,ybottom));

            Polygon pol = new Polygon(p);

            if (a.x==b.x && a.y==b.y) {
                if(pol.inPolygon(a)) System.out.println("T");
                else {
                    if((a.x==xleft || a.x==xright) && (a.y==ytop || a.y==ybottom)) System.out.println("T");
                    else System.out.println("F");
                }


            }
            else {


                Polygon aux = pol.cutPolygon(a, b);

                if (pertenece(a, b, p.get(0)) || pertenece(a, b, p.get(1)) || pertenece(a, b, p.get(2)) || pertenece(a, b, p.get(3))) {
                    System.out.println("T");
                } else {
                    if (aux.pol.isEmpty() || aux.pol.equals(pol.pol)) {
                        System.out.println("F");
                    } else {
                        boolean flag = false;
                        for (int i = 0; i < aux.pol.size(); i++) {
                            if(pertenece(a,b,aux.pol.get(i))) flag=true;
                        }
                        if(pol.inPolygon(a)) flag=true;
                        if(pol.inPolygon(b)) flag=true;
                        if(flag) System.out.println("T");
                        else System.out.println("F");
                    }
                }


            }

        }
    }
}
