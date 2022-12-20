import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class aer643 {

    public static class Basura{
        int peso;
        char tipo;

        public Basura(int peso, char tipo) {
            this.peso = peso;
            this.tipo = tipo;
        }
    }

    public static int veces(int size, Basura[] mem){
        int cont=0;
        long e=0;
        long r=0;
        for (int i = 0; i < mem.length; i++) {
            if(mem[i].tipo=='E'){
                if(mem[i].peso>2*size) return 1000000000;
                if(e+mem[i].peso>2*size){
                    cont++;
                    r=0;
                    e=mem[i].peso;
                }
                else{
                    e+=mem[i].peso;
                }
            }
            else{
                if(mem[i].peso>size) return 1000000000;
                if(r+mem[i].peso>size){
                    cont++;
                    e=0;
                    r=mem[i].peso;
                }
                else{
                    r+=mem[i].peso;
                }
            }
        }
        cont++;

        return cont;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        while(K!=0 && N!=0){
            Basura[] mem = new Basura[N];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(in.readLine());
                mem[i]=new Basura(Integer.parseInt(st.nextToken()),st.nextToken().charAt(0));
            }

            int ini =1;
            int fini = 2000000000;

            while(ini < fini){
                int mid = ini + (fini-ini) / 2;
                if(veces(mid,mem) <= K){
                    fini=mid;
                }
                else{
                    ini=mid+1;
                }
            }

            System.out.println(ini);
            st = new StringTokenizer(in.readLine());
            K = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());


        }

    }
}