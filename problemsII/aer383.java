import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class aer383 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            int sec=in.nextInt();
            int sol=-1000000000;
            int memo=in.nextInt();
            for(int j =0 ;j<sec-1;j++){
                int aux = in.nextInt();
                sol= Math.max(sol,memo-aux);
                if(aux>memo){
                    memo=aux;
                }
            }
            System.out.println(sol);
        }


    }
}