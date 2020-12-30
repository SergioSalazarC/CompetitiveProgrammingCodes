import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        while(n!=0){
            String next=in.readLine();
            while(!next.equals("0")){
                boolean posible=true;
                StringTokenizer st = new StringTokenizer(next," ");
                Stack<Integer> cola = new Stack<>();
                int enun=Integer.parseInt(st.nextToken());
                int coche=1;
                while(true){
                    if(cola.isEmpty()&&coche==n+1){
                        break;
                    }
                    if(coche==enun){
                        if(!st.hasMoreElements())break;
                        String aux=st.nextToken();
                        enun=Integer.parseInt(aux);
                        coche++;
                    }
                    else if(enun>coche){
                        cola.add(coche);
                        coche++;
                    }else if(enun < coche){
                        int aux=cola.pop();
                        if(aux==enun){
                            if(!st.hasMoreElements())break;
                            enun=Integer.parseInt(st.nextToken());
                        }else{
                            posible=false;
                            break;
                        }

                    }
                }
                if(posible) System.out.println("Yes");
                else System.out.println("No");
                next=in.readLine();
            }
            System.out.println();
            n=Integer.parseInt(in.readLine().trim());
        }


    }
}
