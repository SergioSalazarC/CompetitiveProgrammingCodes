import java.util.Scanner;

public class aer592 {
    public static int lista[];

    static long calc(int n, int u, int m){
        long sum = 0;
        for(int i=0; i<n; i++){
            sum+=Math.min(lista[i], u);
            if(sum>m) break;
        }
        return sum;
    }

    static int busqueda(int ls, int li, int n, int m){
        if(ls<=li) return ls;
        int med = (ls+li+1)/2;
        long din = calc( n, med, m);
        if(din <= m)return busqueda(ls, med, n, m);
        else return busqueda(med-1, li, n, m);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int m = in.nextInt();
            int n = in.nextInt();
            lista = new int[n];
            int max = 0;
            for(int i=0; i<n; i++){
                lista[i]=in.nextInt();
                max= Math.max(max, lista[i]);
            }
            System.out.println(busqueda(max, 0, n, m));
        }
    }
}