import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class aer353 {

    public static int INF = 1000000005;
    public static ArrayList<Pair> tesoros;
    public static int N;
    public static int T;
    public static class Pair{
        int profundidad;
        int valor;

        public Pair(int profundidad, int valor) {
            this.profundidad = profundidad;
            this.valor = valor;
        }
    }

    public static int[][] memo;
    public static boolean[][] check;

    public static int[][] vecino;

    public static LinkedList<Integer> solu;

    public static int sol(int indice, int oxigeno){
        if(oxigeno<0) return -INF;
        if(indice>=N) return 0;

        if(check[indice][oxigeno]) return memo[indice][oxigeno];
        check[indice][oxigeno]=true;
        Pair actual = tesoros.get(indice);
        int a = sol(indice+1,oxigeno);
        int b =  sol(indice+1, oxigeno- actual.profundidad)+ actual.valor;
        if(b>a){
            memo[indice][oxigeno]=b;
            vecino[indice][oxigeno]=oxigeno-actual.profundidad;
        }
        else{
            memo[indice][oxigeno]=a;
            vecino[indice][oxigeno]=oxigeno;
        }
        return memo[indice][oxigeno];
    }

    public static void ret(int indice, int oxigeno){
        if(oxigeno<0) return;
        if(indice>=N) return;
        int val = vecino[indice][oxigeno];
        //No se toma ese valor
        if(val==oxigeno){
            ret(indice+1,oxigeno);
        }
        else{
        //se toma el valor
            solu.addLast(indice);
            ret(indice+1,val);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String aux = in.readLine();
        while(aux!=null){
            T = Integer.parseInt(aux);
            N = Integer.parseInt(in.readLine());
            memo = new int[N+1][T+1];
            check = new boolean[N+1][T+1];
            vecino = new int[N+1][T+1];
            tesoros = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                tesoros.add(new Pair(Integer.parseInt(st.nextToken())*3, Integer.parseInt(st.nextToken())));
            }
            solu = new LinkedList<>();
            int valormejor = sol(0,T);
            ret(0,T);
            System.out.println(valormejor);
            System.out.println(solu.size());
            for (Integer i : solu) {
                Pair escogido = tesoros.get(i);
                int profaux = escogido.profundidad/3;
                System.out.println(profaux+" "+ escogido.valor);

            }
            System.out.println("----");



            aux=in.readLine();
        }
    }
}
