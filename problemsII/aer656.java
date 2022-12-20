import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class aer656 {

    public static int chartoindex(char c, int index){
        int aux=5*index;
        if(c=='A') aux+=1;
        if(c=='C') aux+=2;
        if(c=='G') aux+=3;
        if(c=='T') aux+=4;
        return aux;

    }
    public static class Par{
        int nodo;
        int dist;

        public Par(int nodo, int dist) {
            this.nodo = nodo;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            HashSet<Integer>[] grafo = new HashSet[252];
            for (int i = 0; i < 252; i++) {
                grafo[i] =new HashSet<>();
            }

            LinkedList<String> memo = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                String s = in.next();
                memo.add(s);
                for (int j = -1; j < s.length(); j++) {
                    if(j==s.length()-1){
                        int a = chartoindex(s.charAt(j),j);
                        grafo[a].add(252);
                        break;
                    }
                    if(j==-1){
                        int a = chartoindex(s.charAt(0),0);
                        grafo[251].add(a);
                        break;
                    }
                    int a = chartoindex(s.charAt(j),j);
                    int b = chartoindex(s.charAt(j+1),j+1);
                    grafo[a].add(b);
                }
            }
            int sol=0;
            for(String s : memo){
                LinkedList<Integer> cola = new LinkedList();
                int piso = 0;
                cola.addLast(251);
                cola.addLast(null);
                while(!cola.isEmpty()){
                    Integer top = cola.removeFirst();
                    if(top == null){
                        cola.addLast(null);
                        piso++;
                        continue;
                    }
                    if(top>=252){
                        sol++;
                        continue;
                    }
                    char c = s.charAt(piso);
                    if(c=='-'){
                        for(Integer i: grafo[top]){
                            cola.addLast(i);
                        }
                    }
                    else{
                        if(grafo[top].contains(chartoindex(c,piso+1))){
                            cola.add(chartoindex(c,piso));
                        }
                        if(grafo[top].contains((piso+1)*5)){
                            cola.add((piso+1)*5);
                        }
                    }


                }


            }
            System.out.println(sol);





        }
    }
}
