import java.util.Scanner;

public class aer549 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        while(x!=0){
            int[][] memo = new int[x][x];
            for(int i=0;i<x;i++){
                for(int j=0;j<x;j++){
                    memo[i][j]=in.nextInt();
                }
            }
            int mindist=1000000000;
            for(int i=0;i<x;i++){
                //Comprobar diagonal
                boolean unavez=false;
                boolean k=true;
                int aux=memo[0][i];
                int valor=0;
                for(int d=1;d<x && k;d++){
                    if(!unavez){
                        if(memo[ (d)%x][(i+d)%x]>aux){
                            aux=memo[(d)%x][(i+d)%x];
                        }else{
                            aux=memo[(d)%x][(i+d)%x];
                            unavez=true;
                            valor=d;
                        }
                    }
                    else{
                        if(memo[(d)%x][(i+d)%x]>aux){
                            aux=memo[(d)%x][(i+d)%x];
                        }else{
                            k=false;
                        }
                    }

                }
                if(k && unavez){
                    int t=i-1;
                    if(t<0)t+=x;
                    k=memo[0][i]>memo[x-1][t];
                }
                if(k){
                    //System.out.println(i);
                    int px=Math.min((i+valor)%x,x-(valor+i)%x);
                    int py=Math.min((valor)%x,(x-(valor))%x);
                    mindist=Math.min(px+py,mindist);
                }

            }
            if(mindist==1000000000) System.out.println("IMPOSIBLE");
            else System.out.println(mindist);
            x=in.nextInt();

        }
    }
}