import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//PUTISIMAMENTE FUNCIONAAAAAAAAAAAAAAAAAAAAAAAAAAA

public class Main {
    private static ArrayList<Integer>[] graf;
    private static int[] low, disc, parents,ap;
    private static boolean[] visit;

    private static void checkart(int u, int v, int children, int t){
        if(parents[u] == -1 && children>1){
            ap[u]=t;
        }
        if(parents[u] != -1 && low[v]>=disc[u]){
            ap[u]=t;
        }
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
                checkart(u,v,children,t);
            }
            else if(v!=parents[u]){
                low[u]=Math.min(low[u],disc[v]);
            }
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine().trim());

        while(n!=0){
            graf = new ArrayList[n];

            for(int m=0;m<n;m++){
                graf[m]= new ArrayList<>();
            }

            String next= in.readLine();
            while(!next.equals("0")){
                StringTokenizer st=new StringTokenizer(next," ");
                int inicial = Integer.parseInt(st.nextToken())-1;
                int c =st.countTokens();
                for(int i =0;i<c;i++){
                    int aux =Integer.parseInt(st.nextToken())-1;
                    graf[inicial].add(aux);
                    graf[aux].add(inicial);
                }
                next= in.readLine();
            }

            low= new int[n];
            disc= new int[n];
            parents=new int[n];
            for(int i=0;i<n;i++){
                parents[i]=-1;
            }
            ap=new int[n];
            visit= new boolean[n];


            art(0,0);
            int sol=0;
            for(int i=0;i<n;i++){
                if(ap[i]!=0) sol++;
            }
            System.out.println(sol);
            n = Integer.parseInt(in.readLine().trim());
        }

    }
}
