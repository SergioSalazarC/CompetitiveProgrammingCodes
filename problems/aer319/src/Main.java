import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int a =in.nextInt();
            int b =in.nextInt();

            Queue<Integer> cola = new LinkedList();
            boolean[] visitados = new boolean[10010];
            int pisos=0;
            int sol=-1;
            cola.add(null);
            cola.add(a);
            visitados[a]=true;
            if(a==b){
                sol=0;
            }else{
                while(cola.size()>1){
                    Integer pop = cola.remove();
                    if(pop==null){
                        pisos++;
                        cola.add(null);
                    }
                    else{
                        int nuevo = (pop+1)%10000;
                        if(nuevo==b){
                            sol=pisos;
                            break;
                        }
                        if(!visitados[nuevo]){
                            visitados[nuevo]=true;
                            cola.add(nuevo);
                        }

                        int nuevoa = (pop*2)%10000;
                        if(nuevoa==b){
                            sol=pisos;
                            break;
                        }
                        if(!visitados[nuevoa]){
                            visitados[nuevoa]=true;
                            cola.add(nuevoa);
                        }

                        int nuevob = (pop/3)%10000;
                        if(nuevob==b){
                            sol=pisos;
                            break;
                        }
                        if(!visitados[nuevob]){
                            visitados[nuevob]=true;
                            cola.add(nuevob);
                        }

                    }
                }
            }


            System.out.println(sol);



        }

    }
}