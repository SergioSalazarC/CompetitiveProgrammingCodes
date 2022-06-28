import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class aer600 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
         int n=in.nextInt();
         int m=in.nextInt();
         while(n!=0 && m!=0){
             int[][] mat = new int[n][m];
             int[] minimos_filas = new int[n];
             int[] maximos_filas = new int[n];
             int[] minimos_colum = new int[m];
             int[] maximos_colum = new int[m];
             Arrays.fill(minimos_colum,Integer.MAX_VALUE);
             Arrays.fill(minimos_filas,Integer.MAX_VALUE);
             Arrays.fill(maximos_colum,Integer.MIN_VALUE);
             Arrays.fill(maximos_filas,Integer.MIN_VALUE);
             for(int i=0;i<n;i++){
                 int maxF=maximos_filas[i];
                 int minF=minimos_filas[i];
                 for(int j=0;j<m;j++){
                     int aux=in.nextInt();
                     mat[i][j]=aux;
                     minF=Math.min(minF,aux);
                     maxF=Math.max(maxF,aux);
                     minimos_colum[j]= Math.min(minimos_colum[j],aux);
                     maximos_colum[j]= Math.max(maximos_colum[j],aux);
                 }
                 maximos_filas[i]=maxF;
                 minimos_filas[i]=minF;
             }

             boolean flag= false;
             for(int i=0;i<n && !flag;i++){
                 for(int j=0;j<m && !flag;j++){
                     int actual = mat[i][j];
                     flag=((minimos_filas[i]==maximos_colum[j] && minimos_filas[i]==actual) || (maximos_filas[i]==minimos_colum[j] && maximos_filas[i]==actual));
                 }
             }
             if(flag) System.out.println("SI");
             else System.out.println("NO");

             n=in.nextInt();
             m=in.nextInt();

         }

    }
}
