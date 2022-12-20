import java.util.Arrays;
import java.util.Scanner;

public class aer599 {
    static int n;
    static int maxsize;
    static int[][][] memo;
    static int[][] items;
    static int INF = 1000000000;

    static int mochiladoble(int item, int size1, int size2){
        if(size1>maxsize) return -INF;
        if(size2>maxsize) return -INF;
        if(item>=n) return 0;
        if(memo[item][size1][size2]!=-1){
            return memo[item][size1][size2];
        }
        int aux = Math.max(mochiladoble(item+1,size1,size2) , mochiladoble(item+1,size1+items[item][0],size2)+items[item][1]);
        aux = Math.max(aux , mochiladoble(item+1,size1,size2+items[item][0])+items[item][1]);
        memo[item][size1][size2]=aux;
        return aux;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n=in.nextInt();
        while(n!=0){
            maxsize=in.nextInt();
            memo = new int[n][maxsize+1][maxsize+1];
            for(int i=0;i<n;i++){
                for(int j=0;j<maxsize+1;j++){
                    Arrays.fill(memo[i][j],-1);
                }
            }
            items= new int[n][2];
            //[i][0] = duracion
            //[i][1] = puntuacion
            for(int i=0;i<n;i++){
                items[i][0] = in.nextInt();
                items[i][1] = in.nextInt();
            }
            System.out.println(mochiladoble(0,0,0));
            n=in.nextInt();
        }

    }
}