import java.util.Scanner;

public class Main {
    public static void main (String [ ] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while(n!=0){
            int[][] cuadrado = new int[n][n];
            int cm=0;
            int maximo=0;
            boolean condicion1=true;
            for (int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    cuadrado[i][j]= in.nextInt();
                    if (cuadrado[i][j]==maximo){
                        condicion1=false;
                    }else{
                        maximo= Math.max(cuadrado[i][j],maximo);
                    }
                    if(j==0){
                        cm=cm+cuadrado[i][j];
                    }
                }
            }
            boolean diabolico=true;
            for(int i=0;i<n+1 && diabolico;i++){
                if(i<n){
                    int kj=0;
                    int ki=0;
                    for(int j=0;j<n;j++){
                        kj=kj + cuadrado[i][j];
                        ki=ki + cuadrado [j][i];
                    }
                    diabolico = diabolico && (kj==cm) && (ki==cm);
                }else{
                    int d1=0;
                    int d2=0;
                    for(int j=0;j<n;j++){
                        d1= d1+ cuadrado[j][j];
                        d2= d2 + cuadrado[j][n-1-j];
                    }
                    diabolico = diabolico && (d1==cm) && (d2==cm);
                }
            }
            condicion1=condicion1 && (maximo== Math.pow(n,2));
            if(!diabolico){
                System.out.println("NO");
            }else{
                if(!condicion1){
                    System.out.println("DIABOLICO");
                }else{
                    int cm2= (4*cm)/n;
                    int esquinas = cuadrado[0][0]+cuadrado[0][n-1]+cuadrado[n-1][0]+cuadrado[n-1][n-1];
                    boolean condicion2= (esquinas==cm2);
                    if(!condicion2){
                        System.out.println("DIABOLICO");
                    }else{
                        if(n%2==1){
                            int aux = n/2;
                            int medios = cuadrado[0][aux]+cuadrado[aux][0]+cuadrado[aux][n-1]+cuadrado[n-1][aux];
                            int centro = cuadrado[aux][aux]*4;
                            if((medios==cm2)&&(centro==cm2)) System.out.println("ESOTERICO");
                            else System.out.println("DIABOLICO");
                        }else{
                            int aux= n/2;
                            int aux2= n/2 -1;
                            int centro = cuadrado[aux][aux]+cuadrado[aux2][aux]+cuadrado[aux][aux2]+cuadrado[aux2][aux2];
                            int medios = cuadrado[0][aux2]+cuadrado[aux2][0]+cuadrado[aux2][n-1]+cuadrado[n-1][aux2]+cuadrado[0][aux]+cuadrado[aux][0]+cuadrado[aux][n-1]+cuadrado[n-1][aux];
                            if((medios==2*cm2)&&(centro==cm2)) System.out.println("ESOTERICO");
                            else System.out.println("DIABOLICO");
                        }
                    }
                }
            }
            n=in.nextInt();
        }
    }
}