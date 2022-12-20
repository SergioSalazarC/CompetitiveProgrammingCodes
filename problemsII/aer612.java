import java.util.Scanner;

public class aer612 {

    public static int inside(double cx, double cy, double r, double x, double y){
        double k = Math.sqrt((cx-x)*(cx-x)+(cy-y)*(cy-y));
        if(k<=r) return 1;
        return 0;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int cx=0;
            int cy=0;
            int r = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            int cont=0;
            while(r>0){
                cont+=inside(cx,cy,r,x,y);
                int n = cy-cx;
                int m = cy+cx;
                if(y > x+n && y > -x+m){
                    //NORTE
                    cy+=r;
                }
                else if(y < x+n && y > -x+m){
                    //DERECHA
                    cx+=r;
                }
                else if(y < x+n && y < -x+m){
                    //ABAJO
                    cy-=r;
                }
                else if(y > x+n && y < -x+m){
                    //IZQUIERDA
                    cx-=r;
                }
                else{
                    r=0;
                }
                r=r/2;
            }
            System.out.println(cont);

        }
    }
}