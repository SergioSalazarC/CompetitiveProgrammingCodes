import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String aux = in.readLine();
        while(!aux.equals("0 0")){
            StringTokenizer tk = new StringTokenizer(aux," ");
            int med = Integer.parseInt(tk.nextToken());
            int pd = Integer.parseInt(tk.nextToken());
            int solucion=0;
            int acumulador=0;
            int acumpd=0;
            boolean find1=false;
            String aux2= in.readLine();
            StringTokenizer tk2 = new StringTokenizer(aux2," ");
            for(int i=0;i<med;i++){
                int n = Integer.parseInt(tk2.nextToken());
                if(find1){
                    if(n==1){
                        acumpd=0;
                        acumulador++;
                    }
                    else{
                        if(acumpd<pd){
                            acumpd++;
                            acumulador++;
                        }
                        else{
                            acumulador=acumulador-acumpd;
                            find1=false;
                            acumpd=0;
                            solucion=Math.max(solucion,acumulador);
                            acumulador=0;
                        }
                    }
                    if(i==med-1){
                        acumulador=acumulador-acumpd;
                        find1=false;
                        acumpd=0;
                        solucion=Math.max(solucion,acumulador);
                        acumulador=0;
                    }
                }
                else{
                    if(n==1){
                        acumulador=1;
                        find1=true;
                        if(i==med-1){
                            acumulador=acumulador-acumpd;
                            find1=false;
                            acumpd=0;
                            solucion=Math.max(solucion,acumulador);
                            acumulador=0;
                        }
                    }
                }
            }
            System.out.println(solucion);
            aux= in.readLine();
        }
    }
}
