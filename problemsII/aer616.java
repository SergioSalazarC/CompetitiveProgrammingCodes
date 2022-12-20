import java.util.Scanner;

public class aer616 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        while(n!=0){
            int ganador = 0;
            int j1=0;
            int j2=0;
            for(int i=0;i<n;i++){
                String t = in.next();
                if(t.equals("PIC")){
                    ganador=(ganador+1)%2;
                }
                if(t.equals("PONG!")){
                    if(ganador==0) j1++;
                    else j2++;
                }
            }
            System.out.println(j1+" "+j2);
            n=in.nextInt();
        }
    }
}