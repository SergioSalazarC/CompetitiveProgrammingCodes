import java.util.LinkedList;
import java.util.Scanner;

public class aer113 {
    public static class Semaforo implements Comparable{
        double distancia;
        double cerrado;
        double abierto;

        public Semaforo(double distancia, double cerrado, double abierto) {
            this.distancia = distancia;
            this.cerrado = cerrado;
            this.abierto = abierto;
        }

        @Override
        public int compareTo(Object o) {
            Semaforo i = (Semaforo) o;
            return Double.compare(this.distancia,i.distancia);
        }
    }

    public static boolean puedeCruzar(LinkedList<Semaforo> carretera, double velocidad){
        for (Semaforo i : carretera) {
            if(!cruzaSemaforo(i,velocidad))return false;
        }
        return true;
    }


    public static boolean cruzaSemaforo(Semaforo semaforo, double velocidad){
        double tiempotarda = semaforo.distancia/velocidad;
        double dura = semaforo.cerrado+semaforo.abierto;
        long vueltas_completas = (long) (tiempotarda/dura);
        double periodo = tiempotarda - (vueltas_completas*dura);
        if(0.01<periodo && periodo< semaforo.cerrado-0.01)return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int max = in.nextInt();

        while(n!=0 && max!=0){

            LinkedList<Semaforo> carretera = new LinkedList<>();
            long anterior=0;
            boolean flag=true;
            for (int i = 0; i < n; i++) {
                long a = in.nextInt()+anterior;
                int b = in.nextInt();
                int c = in.nextInt();

                if(b==0 || c==0){
                    flag=false;
                }

                carretera.add(new Semaforo(a,b,c));
                anterior = (long) carretera.getLast().distancia;
            }


            Semaforo semaforo_final = carretera.getLast();


            long tarda = 0;
            int i=0;
            if(flag){
                boolean solucion=false;
                while(true){
                    if(i%2==0){
                        tarda += semaforo_final.cerrado;
                    }
                    else{
                        tarda += semaforo_final.abierto;
                    }
                    i++;
                    double velocidadposible = semaforo_final.distancia/tarda;

                    if(velocidadposible>max) continue;
                    if(velocidadposible<0.1) break;
                    else{
                        if(puedeCruzar(carretera,velocidadposible)){
                            solucion=true;
                            System.out.println(tarda);
                            break;
                        }
                    }

                }

                if(!solucion) System.out.println("IMPOSIBLE");
            }
            else{
                System.out.println("IMPOSIBLE");
            }



            n = in.nextInt();
            max = in.nextInt();
        }
    }
}
