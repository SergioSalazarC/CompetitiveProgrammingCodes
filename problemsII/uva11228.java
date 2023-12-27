import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class uva11228 {

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        double dist(Point p){
            return Math.sqrt((x-p.x)*(x-p.x) + (y-p.y)*(y-p.y));
        }
    }

    static class Par implements Comparable{
        Integer nodo;
        Double dist;

        public Par(Integer nodo, Double dist) {
            this.nodo = nodo;
            this.dist = dist;
        }


        @Override
        public int compareTo(Object o) {
            Par i = (Par) o;
            return Double.compare(this.dist,i.dist);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int casos = Integer.parseInt(in.readLine().trim());
        for (int caso = 1; caso <= casos; caso++) {

            StringTokenizer st = new StringTokenizer(in.readLine().trim());

            int n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            Point[] mem = new Point[n];


            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(in.readLine().trim());
                Point p = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
                mem[i]=p;
            }


            PriorityQueue<Par> pq = new PriorityQueue<>();
            boolean[] visitado= new boolean[n];
            visitado[0]=true;
            for (int i = 1; i < n; i++) {
                pq.add(new Par(i,mem[0].dist(mem[i])));
            }
            int states=1;
            double coster=0;
            double costerr=0;
            int cant=1;
            while (!pq.isEmpty()){
                Par top=pq.remove();
                if(!visitado[top.nodo]){
                    visitado[top.nodo]=true;
                    cant++;
                    if(top.dist>r){
                        states++;
                        costerr+=top.dist;
                    }
                    else{
                        coster+=top.dist;
                    }
                    for (int i = 0; i < n; i++) {
                        if(visitado[i])continue;
                        pq.add(new Par(i,mem[top.nodo].dist(mem[i])));
                    }
                }
            }

            int a = (int) (coster+0.5);
            int b  = (int) (costerr+0.5);

            System.out.println("Case #"+ caso +": "+ states+" "+a+" "+b);









        }


    }
}
