import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class aer394 {
    public static class Nodo{
        Nodo hi;
        Nodo hd;

        public Nodo() {
            hi=null;
            hd=null;
        }
    }

    public static class Par{
        int raiz;
        int total;

        public Par(int r, int t) {
            this.raiz=r;
            this.total=t;
        }
    }

    public static Par sol(Nodo arbol){
        if(arbol.hi==null && arbol.hd==null) return new Par(0,0);
        if(arbol.hi==null){
            Par d = sol(arbol.hd);
            return new Par(0,d.total);
        }

        Par d = sol(arbol.hd);
        Par i = sol(arbol.hi);
        int raiz_actual = 1+Math.min(d.raiz,i.raiz);
        int total_actual = Math.max(raiz_actual,Math.max(d.total,i.total));
        return new Par(raiz_actual,total_actual);




    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = Integer.parseInt(in.nextLine());

        while(s-->0){
            Stack<Nodo> pila = new Stack();

            Nodo arbol = new Nodo();
            pila.push(arbol);
            String def = in.nextLine();
            StringTokenizer st = new StringTokenizer(def," ");
            while(st.hasMoreElements()){
                int k = Integer.parseInt(st.nextToken());
                Nodo aux = pila.pop();
                if(k==0){
                    continue;
                }
                if(k==1){
                    aux.hd = new Nodo();
                    pila.add(aux.hd);
                }
                if(k==2){
                    aux.hd = new Nodo();
                    aux.hi = new Nodo();
                    pila.add(aux.hi);
                    pila.add(aux.hd);
                }
            }
            Par sol = sol(arbol);
            System.out.println(sol.total);
        }
    }
}
