import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(in.readLine().trim());
        for(int s=0;s<t;s++){
            int n = Integer.parseInt(in.readLine().trim());
            PriorityQueue<Integer> a = new PriorityQueue(Comparator.reverseOrder());
            StringTokenizer st= new StringTokenizer(in.readLine()," ");
            for(int i=0;i<n;i++){
                a.add(Integer.parseInt(st.nextToken()));
            }
            long alice=0;
            long bob=0;
            int contador=0;
            while (!a.isEmpty()){
                Integer aux=a.remove();
                if(contador%2==0 && aux%2==0){
                    alice+=aux;
                }
                else if(contador%2==1 && aux%2==1){
                    bob+=aux;
                }
                contador++;
            }

            if(alice>bob) System.out.println("Alice");
            else if(alice==bob) System.out.println("Tie");
            else System.out.println("Bob");


        }
    }
}
