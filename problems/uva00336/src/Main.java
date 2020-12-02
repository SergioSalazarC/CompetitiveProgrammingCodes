import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nc = in.nextInt();
        int caso=1;
        while(nc!=0){
            int cont=0;
            ArrayList<Integer>[] graf = new ArrayList[2*nc];
            HashMap<Integer,Integer> dic=new HashMap<>();
            for(int i =0;i<nc;i++){
                int a=in.nextInt();
                int b=in.nextInt();
                if(!dic.containsKey(a)){
                    dic.put(a,cont);
                    cont++;
                }
                if(!dic.containsKey(b)){
                    dic.put(b,cont);
                    cont++;
                }
                if(graf[dic.get(a)]==null){
                    graf[dic.get(a)]=new ArrayList<>();
                }
                if(graf[dic.get(b)]==null){
                    graf[dic.get(b)]=new ArrayList<>();
                }

                graf[dic.get(a)].add(dic.get(b));
                graf[dic.get(b)].add(dic.get(a));

            }

            int start=in.nextInt();
            int pisos=in.nextInt();

            while(start!=0 || pisos!=0){

                if(!dic.containsKey(start)){
                    System.out.println("Case "+caso+": "+cont+" nodes not reachable from node "+start+" with TTL = "+pisos+".");
                }else{


                    int aux=pisos;

                    HashSet<Integer> visitados= new HashSet<>();
                    Queue<Integer> cola = new LinkedList<>();
                    visitados.add(dic.get(start));
                    cola.add(dic.get(start));
                    cola.add(null);

                    while(cola.size()>1 && aux>0){
                        Integer pop= cola.remove();
                        if(pop==null){
                            aux--;
                            cola.add(null);
                        }
                        else{
                            for(Integer k: graf[pop]){
                                if(!visitados.contains(k)){
                                    cola.add(k);
                                    visitados.add(k);
                                }
                            }
                        }
                    }

                    int sol = cont-visitados.size();
                    System.out.println("Case "+caso+": "+sol+" nodes not reachable from node "+start+" with TTL = "+pisos+".");

                }
                caso++;
                start=in.nextInt();
                pisos=in.nextInt();
            }

            nc=in.nextInt();

        }
    }
}
