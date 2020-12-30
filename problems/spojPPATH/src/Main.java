import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        boolean[] criba = new boolean[10000];
        for(int i=2;i<=9999;i++){
            if(criba[i]==false){
                int aux=i+i;
                while(aux<10000){
                    criba[aux]=true;
                    aux+=i;
                }
            }
        }



        int casos=in.nextInt();
        for(int i=0;i<casos;i++){
            int inicio=in.nextInt();
            int end=in.nextInt();
            int pisos=0;
            int[]dist = new int[10000];
            boolean[] visit = new boolean[10000];
            visit[inicio]=true;
            Queue<Integer> cola = new LinkedList<>();
            cola.add(null);
            cola.add(inicio);
            while(cola.size()>1){
                Integer pop = cola.poll();
                if(pop==null){
                    pisos++;
                    cola.add(null);
                }
                else{
                    int u=pop%10;
                    int d=pop%100;
                    int c=pop%1000;
                    for(int m=0;m<10;m++){
                        if(pop-u+m>9999) continue;
                        if(!visit[pop-u+m] && !criba[pop-u+m]){
                            visit[pop-u+m]=true;
                            dist[pop-u+m]=pisos;
                            cola.add(pop-u+m);
                        }
                    }
                    for(int m=0;m<10;m++){
                        var i1 = pop - d + u + m * 10;
                        if(i1>9999) continue;
                        if(!visit[i1] && !criba[i1]){
                            visit[i1]=true;
                            dist[i1]=pisos;
                            cola.add(i1);
                        }
                    }
                    for(int m=0;m<10;m++){
                        var i1 = pop - c + d + m * 100;
                        if(i1>9999) continue;
                        if(!visit[i1] && !criba[i1]){
                            visit[i1]=true;
                            dist[i1]=pisos;
                            cola.add(i1);
                        }
                    }
                    for(int m=1;m<10;m++){
                        var i1 = c+ 1000*m;
                        if(i1>9999) continue;
                        if(!visit[i1] && !criba[i1]){
                            visit[i1]=true;
                            dist[i1]=pisos;
                            cola.add(i1);
                        }
                    }
                }
            }
            if(visit[end]==false) System.out.println("Impossible");
            else System.out.println(dist[end]);


        }
    }
}
