import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static LinkedList<Integer> cola;
    public static LinkedList<Integer> pila;

    public static void voltear(int i){
        cola = new LinkedList<>();
        for(int j=0;j<i;j++){
            int x =pila.remove(0);
            cola.add(0,x);
        }
        for(int j=0;j<i;j++){
            int x=cola.removeLast();
            pila.add(0,x);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int aux=in.nextInt();
        while(aux>0){
            pila = new LinkedList<>();
            pila.add(aux);
            while(true){
                int m = in.nextInt();
                if(m<0) break;
                else{
                    pila.add(0,m);
                }
            }
            int p =in.nextInt();
            for(int i=0;i<p;i++){
                voltear(in.nextInt());
            }
            System.out.println(pila.remove(0));
            aux = in.nextInt();

        }
    }
}