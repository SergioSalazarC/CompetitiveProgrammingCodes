import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static int rec(ArrayList<Integer> discos, ArrayList<Integer> solucion, int duracion){
        int sol=0;

        for(int i=0;i<discos.size();i++){
            ArrayList<Integer> aux  = new ArrayList(discos);
            int m = aux.remove(i);
            solucion.add(m);
            int ab=0;
            for(Integer b : solucion){
                ab+=b;
            }
            if(ab==duracion){
                sol=Math.max(sol,ab);
            }
            if(ab>duracion){
                sol = Math.max(ab-m,sol);
            }

            if(ab<duracion){
                sol=Math.max(sol,rec(aux,solucion,duracion));
            }
        }



        return(sol);


    }




    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();
        while(line!=null){
            StringTokenizer st = new StringTokenizer(line," ");
            int duracion = Integer.parseInt(st.nextToken());
            int cantidad = Integer.parseInt(st.nextToken());
            ArrayList<Integer> discos = new ArrayList<>();
            for(int i = 0; i<cantidad ; i++){
                discos.add(Integer.parseInt(st.nextToken()));
            }

            ArrayList<Integer> solucion = new ArrayList<>();

            int a = rec(discos,solucion,duracion);

            System.out.println(a);

            line = in.readLine();


        }
    }
}
