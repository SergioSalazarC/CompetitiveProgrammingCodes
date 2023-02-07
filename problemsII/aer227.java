import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class aer227 {

    static int modInverse(int a, int m)
    {
        int m0 = m;
        int y = 0, x = 1;
        if (m == 1) return 0;
        while (a > 1) {
            // q is quotient
            int q = a / m;
            int t = m;
            // m is remainder now, process same as Euclid's algo
            m = a % m;
            a = t;
            t = y;
            // Update x and y
            y = x - q * y;
            x = t;
        }
        // Make x positive
        if (x < 0)
            x += m0;
        return x;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringBuilder solv = new StringBuilder();

        while(n!=0 && m!=0){
            int mul = n;
            int div = 1;
            long sol = 1;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= m; i++) {
                sb.append(sol).append(" ");
                sol = (sol*mul)%1000000007;
                int aux = modInverse(div,1000000007);
                sol = (sol * aux)%1000000007;
                mul--;
                div++;

            }
            solv.append(sb.toString().trim()).append("\n");
            st = new StringTokenizer(in.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
        }
        System.out.print(solv);
    }
}
