import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main (String [ ] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n=in.nextInt();
            int[][] mat = new int[n][n];
            for(int x=0;x<n;x++){
                Arrays.fill( mat[x], 1000000000 );
            }
            for(int i=0;i<n-1;i++){
                mat[i][i]=0;
                for(int j=i+1;j<n;j++){
                    mat[i][j] =in.nextInt();
                }
            }

            for(int k =0;k<n;k++){
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        mat[i][j]= Math.min(mat[i][j], mat[i][k]+mat[k][j]);
                    }
                }
            }

            for(int i=0;i<n-1;i++){
                mat[i][i]=0;
                for(int j = i+1;j<n;j++){
                    System.out.print(mat[i][j]);
                    if(j==n-1){
                        System.out.println();
                    }else{
                        System.out.print(" ");
                    }
                }
            }
        }

    }
}