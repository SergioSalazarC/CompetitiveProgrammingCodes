import java.util.Scanner;

public class Main {

    public static int size;
    public static int puntos[][];
    public static int memo[][];
    public static boolean mark[][];

    public static int dist(int a1, int a2, int b1, int b2){
        return (Math.abs(a1-b1)+Math.abs(a2-b2));
    }

    public static int dp(int situationa, int situationb,int go){
        if(go>size)return 0;
        if(mark[situationa][situationb]) return memo[situationa][situationb];
        int max=0;
        mark[situationa][situationb]=true;
        if (situationa==situationb){
            max=dist(puntos[situationa][0],puntos[situationa][1],puntos[go][0],puntos[go][1])+dp(go,situationb,go+1);
        }
        else{
            max=Math.min(dist(puntos[situationa][0],puntos[situationa][1],puntos[go][0],puntos[go][1])+dp(go,situationb,go+1),dist(puntos[situationb][0],puntos[situationb][1],puntos[go][0],puntos[go][1])+dp(situationa,go,go+1));
        }
        memo[situationa][situationb]=max;
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            size=in.nextInt();
            puntos = new int[size+1][2];
            memo=new int [size+1][size+1];
            mark=new boolean [size+1][size+1];
            for(int j=1;j<=size;j++){
                int a=in.nextInt();
                int b=in.nextInt();
                puntos[j][0]=a;
                puntos[j][1]=b;
            }
            int sal = dp(0,0,1);
            System.out.println(sal);
        }
    }
}