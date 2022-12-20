import java.util.Scanner;

public class aer531 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            double reps = in.nextInt();
            double repsmal=in.nextInt();
            double hum=in.nextInt();
            double hummal=in.nextInt();
            double humanos=in.nextInt();
            double replicantes=in.nextInt();

            double replicpillados= (double) (replicantes * (reps-repsmal)) / reps;
            double humanospillados = (double) (humanos * hummal)/hum;

            if(humanospillados*10 <= (humanospillados+replicpillados)){
                System.out.println("APRUEBA");
            }
            else System.out.println("SUSPENDE");
        }
    }
}