import java.util.Scanner;

public class Torneo_TLE {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            long c = in.nextLong();
            long partidos = 0;
            while(c!=1){
                partidos+=c/2;
                if(c%2==0){
                    c=c/2;
                }
                else{
                    c=(c/2)+1;
                }
            }
            System.out.println(partidos);
        }
    }
}
