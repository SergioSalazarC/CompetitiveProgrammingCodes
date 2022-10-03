import java.lang.management.MemoryType;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class cf1468F {
    public static long gcd(long a, long b){
        if(b==0) return a;
        if(a==0) return b;
        else return gcd(b,a%b);
    }

    public static class IntPair{
        Long x;
        Long y;

        public IntPair(long x, long y) {
            this.x = x;
            this.y = y;
        }


        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object o) {

            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            IntPair intPair = (IntPair) o;
            return Objects.equals(x, intPair.x) && Objects.equals(y, intPair.y);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int casos = in.nextInt();
        while(casos-->0){
            int n = in.nextInt();
            HashMap<IntPair,Long> mem = new HashMap<>();
            for (int i = 0; i < n; i++) {
                long x=in.nextInt();
                long y=in.nextInt();
                long u=in.nextInt()-x;
                long v=in.nextInt()-y;
                long aux = gcd(Math.abs(u),Math.abs(v));
                u/=aux;
                v/=aux;
                IntPair vector = new IntPair(u,v);
                if(mem.containsKey(vector)){
                    mem.put(vector,mem.get(vector)+1);
                }
                else{
                    mem.put(vector,(long)1);
                }
            }
            long sol=0;
            for (IntPair v : mem.keySet()){
                IntPair aux = new IntPair(-v.x,-v.y);
                if(mem.containsKey(aux)){
                    sol+=mem.get(v)*mem.get(aux);
                }
            }
            sol/=2;
            System.out.println(sol);
        }

    }
}
