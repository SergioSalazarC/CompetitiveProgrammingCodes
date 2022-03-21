import java.util.LinkedList;
import java.util.Scanner;

public class aer204 {

    public static class Nodo{
        boolean boladenavidad;
        Nodo derecho,izquierdo;

        public Nodo(boolean boladenavidad) {
            this.boladenavidad = boladenavidad;
        }

    }

    public static Nodo contruir(String definicion){
        Nodo devolver = new Nodo(false);
        LinkedList<Nodo> pila = new LinkedList<>();
        pila.addFirst(devolver);
        int cont=0;
        while(!pila.isEmpty()){
            Nodo elemento = pila.removeFirst();
            if(definicion.charAt(cont)=='.'){
                elemento.boladenavidad=false;
            }
            else if(definicion.charAt(cont)=='*'){
                elemento.boladenavidad=true;
            }
            else{
                elemento.boladenavidad=false;
                elemento.derecho=new Nodo(false);
                elemento.izquierdo=new Nodo(false);
                pila.addFirst(elemento.derecho);
                pila.addFirst(elemento.izquierdo);
            }
            cont++;
        }
        return devolver;
    }

    public static int decorado(Nodo arbol)
    {
        int derecho=0;
        int izquierdo=0;
        if(arbol.derecho!=null){
            derecho=decorado(arbol.derecho);
            izquierdo=decorado(arbol.izquierdo);
        }
        else{
            if(arbol.boladenavidad)return 1;
            else return 0;
        }
        if(Math.abs(derecho-izquierdo)>1){
            return -1;
        }
        if(derecho==-1 ||izquierdo==-1){
            return -1;
        }

        return derecho+izquierdo;

    }

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        while(in.hasNext()){
            String x = in.next();
            Nodo arbol = contruir(x);
            int y = decorado(arbol);
            if(y==-1) System.out.println("KO");
            else System.out.println("OK");

        }

    }
}
