import java.util.HashSet;
import java.util.Scanner;

public class uva10865 {
    public static class point{
        long x;
        long y;

        public point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        while(n!=0){
            int mid = n/2;
            point[] mem = new point[mid];
            for (int i = 0; i < mid; i++) {
                mem[i]=new point(in.nextLong(),in.nextLong());
            }

            point centre = new point(in.nextLong(),in.nextLong());

            int pos=0;
            int neg=0;

            for (int i = 0; i < mid; i++) {
                long x = in.nextLong()-centre.x;
                long y = in.nextLong()- centre.y;

                if(x*y>0)pos++;
                if(x*y<0)neg++;
            }
            for (int i = 0; i < mid; i++) {
                long x = mem[i].x- centre.x;
                long y = mem[i].y - centre.y;

                if(x*y>0)pos++;
                if(x*y<0)neg++;
            }

            System.out.println(pos+" "+neg);

            n = in.nextInt();


        }
    }
}
