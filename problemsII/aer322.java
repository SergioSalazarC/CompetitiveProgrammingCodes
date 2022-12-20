import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class aer322 {


    static int[][] index;
    static boolean[][] check;
    static StringBuilder sol = new StringBuilder("");

    public static int func(int start, int end, String x){
        if(end-start<0){
            return 0;
        }
        //Un solo caracter
        if(start==end ){
            return 1;
        }
        //Dos caracteres iguales
        if(end-start==1 && x.charAt(start)==x.charAt(end)){
            return 2;
        }
        else{
            if(check[start][end]){
                return index[start][end];
            }
            if(x.charAt(start)==x.charAt(end)){
                int t = func(start+1,end-1,x)+2;
                check[start][end]=true;
                index[start][end]=t;
                return index[start][end];
            }
            else{
                int t = func(start,end-1,x);
                int j = func(start+1,end,x);
                check[start][end]=true;
                index[start][end]=Math.max(t,j);
                return index[start][end];
            }
        }
    }

    public static int print(int start, int end, String x){
        if(end-start<0){
            return 0;
        }
        if(start==end){
            sol.append(x.charAt(start));
            return 1;
        }
        if(end-start==1 && x.charAt(start)==x.charAt(end)){
            sol.append(x.charAt(start));
            sol.append(x.charAt(start));
            return 2;
        }
        else if(index[start][end]==func(start+1,end-1,x)+2 && x.charAt(start)==x.charAt(end)){
            StringBuilder aux = new StringBuilder();
            aux.append(x.charAt(start));
            print(start+1,end-1,x);
            sol.append(aux);
            aux.append(sol);
            sol=aux;
            return 2;
        }
        else if(index[start][end]==func(start+1,end,x)){
            print(start+1,end,x);
            return 2;
        }
        else if(index[start][end]==func(start,end-1,x)){
            print(start,end-1,x);
            return 2;
        }

        else if(index[start][end]==func(start+1,end-1,x)+2){
            StringBuilder aux = new StringBuilder();
            aux.append(x.charAt(start));
            print(start+1,end-1,x);
            sol.append(aux);
            aux.append(sol);
            sol=aux;
            return 2;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        String lect=in.readLine();
        while(lect!=null){
            index = new int[lect.length()+5][lect.length()+5];
            check = new boolean[lect.length()+5][lect.length()+5];
            int m = func(0,lect.length()-1,lect);
            print(0,lect.length()-1,lect);
            System.out.println(sol);
            //output.write(sol.toString()+"\n");
            sol = new StringBuilder("");
            lect=in.readLine();
        }
        //output.flush();
    }
}