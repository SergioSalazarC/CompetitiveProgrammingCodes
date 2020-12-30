import java.util.Scanner;

public class Main {


    public static int meses;
    public static int contratar;
    public static int salario;
    public static int despedir;
    public static int[] cal;
    public static int INF=1000000000;
    public static int[][] graf;
    public static boolean[][] mark;
    public static int max=-1;

    public static int dp(int mes, int trabajadores){
        if(trabajadores<0) return INF;
        if(trabajadores>max) return INF;
        if(mes==meses) return 0;
        if(mark[mes][trabajadores]) return graf[mes][trabajadores];
        mark[mes][trabajadores]=true;
        int best=INF;
        if(trabajadores < cal[mes]){
            best=dp(mes+1,cal[mes])+(salario*cal[mes]+contratar*(cal[mes]-trabajadores));
        }else{
            int aux=trabajadores-cal[mes];
            for(int i=0;i<=aux;i++){
                best=Math.min(best,dp(mes+1,trabajadores-i)+(salario*(trabajadores-i)+(i)*despedir));
            }

        }
        graf[mes][trabajadores]=best;
        return best;


    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
         meses = in.nextInt();
         int caso=0;
        while(meses!=0){
            caso++;
            contratar=in.nextInt();
            salario=in.nextInt();
            despedir=in.nextInt();
            cal=new int[meses];
            for(int i=0;i<meses;i++){
                int aux=in.nextInt();
                max=Math.max(max,aux);
                cal[i]=aux;
            }
            graf=new int[50][max+50];
            mark= new boolean[50][max + 50];
            int resultado=dp(0,0);

            System.out.println("Case "+caso+", cost = $"+resultado);
            meses = in.nextInt();

        }
    }
}
