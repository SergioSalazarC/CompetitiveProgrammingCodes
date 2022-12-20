import java.util.Scanner;

public class aer472 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int D = in.nextInt();
            int n = in.nextInt();
            int anterior=in.nextInt();
            int desnivel=0;
            int desniveltotal=0;

            for (int i = 1; i < n; i++) {
                int actual = in.nextInt();
                if(actual>anterior) desnivel+=(actual-anterior);
                else{
                    desniveltotal = Math.max(desniveltotal,desnivel);
                    desnivel=0;
                }
                anterior=actual;

            }
            desniveltotal = Math.max(desniveltotal,desnivel);

            if(desniveltotal>D){
                System.out.println("NO APTA");
            }
            else{
                System.out.println("APTA");
            }
        }
    }
}
