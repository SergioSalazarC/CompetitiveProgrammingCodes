import java.util.*;

public class Main {

    private static ArrayList<Integer>[] graf;
    private static int[] low,disc;
    private static boolean[] visit;
    private static Queue<Integer> ordvis;
    private static int numssc;

    private static void art (int u,int t){
        low[u]=t;
        disc[u]=t++;
        ordvis.add(u);
        visit[u]=true;
        for(Integer v: graf[u]){
            if(disc[v] == -1){
                art(v,t);
            }
            if(visit[v]){
                low[u]=Math.min(low[u],low[v]);
            }
        }

        if(low[u]==disc[u]){
            numssc++;
            System.out.println("SSC:"+numssc);
            while(true){
                int v = ordvis.remove();
                visit[v]=false;
                System.out.println(v);
                if(u==v) break;
            }

        }
    }

    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        while(n!=0 || m!=0){
            graf = new ArrayList[n];
            for(int i=0;i<n;i++){
                graf[i]=new ArrayList<>();
            }

            for(int i=0;i<m;i++){
                int v=in.nextInt();
                int w=in.nextInt();
                int p=in.nextInt();
                graf[v].add(w);
                if(p==2){
                    graf[w].add(v);
                }
            }

            low = new int[n];
            disc=new int[n];
            visit=new boolean[n];
            ordvis=new LinkedList<>();
            Arrays.fill(disc,-1);
            numssc=0;
            art(0,0);



        }
    }
}
