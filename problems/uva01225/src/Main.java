import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            int m=in.nextInt();
            StringBuilder aux = new StringBuilder();

            for(int j=1;j<=m;j++){
                aux.append(j);
            }
            String fin = aux.toString();
            int[] cont = new int[10];
            for(int j=0;j<fin.length();j++){
                cont[fin.charAt(j)-48]++;
            }

            System.out.println(cont[0]+" "+cont[1]+" "+cont[2]+" "+cont[3]+" "+cont[4]+" "+cont[5]+" "+cont[6]+" "+cont[7]+" "+cont[8]+" "+cont[9]);
        }
    }
}
