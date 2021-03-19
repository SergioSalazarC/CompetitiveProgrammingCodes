import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i=in.nextInt();
        while(i!=0){
            int personas=1;
            int sumas=i;
            i=in.nextInt();
            while(i!=0){
                personas++;
                sumas=sumas+i;
                i=in.nextInt();
            }
            if(sumas%personas==0){
                System.out.println("REPARTO JUSTO");
            }else{
                System.out.println("IMPOSIBLE");
            }
            i=in.nextInt();
        }
    }
}