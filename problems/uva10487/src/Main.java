import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int cant = Integer.parseInt(in.readLine());
        int contador=1;
        while(cant!=0){
            int[] numbers = new int[cant];
            for(int i=0;i<cant;i++){
                numbers[i]=Integer.parseInt(in.readLine());
            }

            int next = Integer.parseInt(in.readLine());

            System.out.println("Case "+contador+":");
            for(int i=0;i<next;i++){
                int num = Integer.parseInt(in.readLine());
                int min = -2000000000;
                for(int a=0;a<cant;a++){
                    for(int b=a+1;b<cant;b++){
                        if (Math.abs(numbers[a]+numbers[b]-num)<Math.abs(min-num)){
                            min=numbers[a]+numbers[b];
                        }
                    }
                }

                System.out.println("Closest sum to "+num+" is "+min+".");

            }
            contador++;
            cant = Integer.parseInt(in.readLine());

        }


    }
}
