import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class ReadmeScript {
    private static class Problema implements Comparable{
        int id;
        String url;

        public Problema(int id, String url) {
            this.id = id;
            this.url = url;
        }

        @Override
        public int compareTo(Object o) {
            Problema k = (Problema) o;
            return this.id-k.id;
        }
    }

    public static void main(String[] args) {
        File carpeta1 = new File("problems");
        String[] lista = carpeta1.list();
        ArrayList<Problema> problemas = new ArrayList<>();
        for (int i = 0; i < lista.length; i++) {

            if(lista[i].contains("aer")){
                int id = Integer.parseInt(lista[i].substring(3));
                problemas.add(new Problema( id , "[AceptaElReto "+id+"](./problems/"+lista[i]+"/src/Main.java)  "));
            }
        }

        File carpeta2 = new File("problemsII");
        lista = carpeta2.list();
        for (int i = 0; i < lista.length; i++) {

            if(lista[i].contains("aer")){
                int id = Integer.parseInt(lista[i].substring(3,6));
                problemas.add(new Problema(id, "[AceptaElReto "+id+"](./problemsII/"+lista[i]+")  "));
            }
        }

        Collections.sort(problemas);

        for(Problema p : problemas){
            System.out.println(p.url);
        }
    }
}
