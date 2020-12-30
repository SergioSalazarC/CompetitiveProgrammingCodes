import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int a=Integer.parseInt(in.readLine());
        int i=1;
        StringBuilder sol = new StringBuilder();
        while(a!=0){
            if(a==1)sol.append("Case "+i+", N = 1, # of different labelings = 1\n");
            else if(a==2)sol.append("Case "+i+", N = 2, # of different labelings = 1\n");
            else if(a==3)sol.append("Case "+i+", N = 3, # of different labelings = 3\n");
            else if(a==4)sol.append("Case "+i+", N = 4, # of different labelings = 16\n");
            else if(a==5)sol.append("Case "+i+", N = 5, # of different labelings = 125\n");
            else if(a==6)sol.append("Case "+i+", N = 6, # of different labelings = 1296\n");
            else if(a==7)sol.append("Case "+i+", N = 7, # of different labelings = 16807\n");
            else if(a==8)sol.append("Case "+i+", N = 8, # of different labelings = 262144\n");
            else if(a==9)sol.append("Case "+i+", N = 9, # of different labelings = 4782969\n");
            else if(a==10)sol.append("Case "+i+", N = 10, # of different labelings = 100000000\n");
            i++;
            a=Integer.parseInt(in.readLine());
        }
        System.out.print(sol);
    }
}
