import java.util.Scanner;
public class main {
    public static int rec(String s,int i,int j, int[][] memo, boolean[][]visit){

        if(i>j){
            return 0;
        }
        if(i==j){
            return 1;
        }
        if(visit[i][j]==true) return memo[i][j];
        int aux;
        if(s.charAt(i)==s.charAt(j)){
            aux=2+rec(s,i+1,j-1,memo,visit);
        }else{
            aux= Math.max(rec(s,i+1,j,memo,visit),rec(s,i,j-1,memo,visit));
        }
        visit[i][j]=true;
        memo[i][j]=aux;
        return aux;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

            while(in.hasNext()){
                String n=in.nextLine();
                boolean[][] visitado = new boolean[101][101];
                int[][] memo=new int[101][101];
                System.out.println(n.length()-rec(n,0,n.length()-1,memo,visitado));

            }
    }
}