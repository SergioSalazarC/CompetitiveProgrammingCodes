import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class aer644 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int A = Integer.parseInt(in.readLine());
        while(A!=0){
            int M=24;
            int N=5;
            int a = A%19;
            int b = A%4;
            int c = A%7;
            int d = (19*a + M)%30;
            int e = (2*b + 4*c + 6*d +N)%7;
            if(d+e<10){
                //MARZO
                int dia = d+e+22;
                sb.append(dia).append(" de marzo").append("\n");
            }
            else{
                //ABRIL
                int dia = d+e-9;
                if(dia == 26) dia =19;
                if(dia == 25 && d == 28) dia = 18;
                sb.append(dia).append(" de abril").append("\n");
            }
            A = Integer.parseInt(in.readLine());
        }
        System.out.print(sb);
    }
}