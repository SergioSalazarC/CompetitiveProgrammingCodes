import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    private static ArrayList<Integer>[] graf;
    private static int[] low, disc, parents,ap;
    private static boolean[] visit;

    private static void checkart(int u, int v, int children, int t){
        if(parents[u] == -1 && children>1) ap[u]=t;
        if(parents[u] != -1 && low[v]>=disc[u])  ap[u]=t;
    }

    private static void art (int u, int t){
        visit[u]=true;
        disc[u]=t;
        low[u]=t++;
        int children=0;
        for(Integer v: graf[u]){
            if(!visit[v]){
                children++;
                parents[v] = u;
                art(v,t);
                low[u]=Math.min(low[u], low[v]);
                checkart(u,v,children,t); }
            else if(v!=parents[u])
                low[u]=Math.min(low[u],disc[v]);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine().trim());
        int caso=1;
        while(n!=0){
            if(caso!=1){
                System.out.println();
            }
            graf=new ArrayList[n];
            HashMap<Integer,String> dic=new HashMap<>();
            HashMap<String,Integer> dic1=new HashMap<>();
            for(int i=0;i<n;i++){
                graf[i]=new ArrayList<>();
                String aux = in.readLine();
                dic.put(i,aux);
                dic1.put(aux,i);
            }
            int v=Integer.parseInt(in.readLine());
            for(int i=0;i<v;i++){
                String aux=in.readLine();
                StringTokenizer st = new StringTokenizer(aux," ");
                String c1=st.nextToken();
                String c2=st.nextToken();
                graf[dic1.get(c1)].add(dic1.get(c2));
                graf[dic1.get(c2)].add(dic1.get(c1));
            }

            low=new int[n];
            disc=new int[n];
            parents=new int[n];
            Arrays.fill(parents,-1);
            ap=new int[n];
            visit=new boolean[n];

            for(int i=0;i<n;i++){
                if(!visit[i])art(i,1);
            }

            ArrayList<String>d= new ArrayList<>();
            for(int i=0;i<n;i++){
                if(ap[i]!=0) d.add(dic.get(i));
            }
            Collections.sort(d);

            System.out.println("City map #"+caso+": "+d.size()+" camera(s) found");
            for(String r:d){
                System.out.println(r);
            }
            caso++;
            n=Integer.parseInt(in.readLine().trim());
        }
    }
}
