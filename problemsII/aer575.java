import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class aer575 {
    public static LinkedList<Integer> orden;
    public static ArrayList<Integer>[] graf ;
    public static int[] dfs_num;
    public static int[] dfs_low;
    public static boolean[] visited;
    public static int contador;

    public static int strongConnectedComponents(int u){
        dfs_low[u]=dfs_num[u]=contador++;
        orden.addLast(u);
        visited[u]=true;
        int size=0;
        for(int i=0;i<graf[u].size();i++){
            int v = graf[u].get(i);
            if(dfs_num[v]==-1){
                size=Math.max(size,strongConnectedComponents(v));
            }
            if(visited[v])
                dfs_low[u]=Math.min(dfs_low[u],dfs_low[v]);
        }
        int sizeaux=0;
        if(dfs_low[u]==dfs_num[u]){
            while(true){
                int v = orden.removeLast();
                visited[v]=false;
                sizeaux++;
                if(u==v) break;
            }
        }
        size=Math.max(size,sizeaux);
        return size;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String caso=in.readLine();
        while(caso!=null){
            int h = Integer.parseInt(caso);
            graf = new ArrayList[h];
            for(int i=0;i<h;i++){
                graf[i]=new ArrayList<>();
            }
            String q = in.readLine().trim();
            while(!q.equals("0")){
                StringTokenizer st = new StringTokenizer(q, " ");
                int t=Integer.parseInt(st.nextToken())-1;
                int cant=Integer.parseInt(st.nextToken());
                for(int i=0;i<cant;i++){
                    graf[t].add(Integer.parseInt(st.nextToken())-1);
                }
                q = in.readLine().trim();
            }

            orden = new LinkedList<>();
            dfs_low=new int[h];
            dfs_num=new int[h];
            Arrays.fill(dfs_num,-1);
            Arrays.fill(dfs_low,-1);
            visited=new boolean[h];
            contador=0;
            int max=0;
            for(int i=0;i<h;i++){
                if(dfs_num[i]==-1){
                    max=Math.max(max,strongConnectedComponents(i));
                }
            }
            System.out.println(max);
            caso=in.readLine();
        }
    }
}