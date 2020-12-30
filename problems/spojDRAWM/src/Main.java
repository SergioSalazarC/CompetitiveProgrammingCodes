import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t!=-1){
            StringTokenizer st=new StringTokenizer(in.readLine()," ");
            int[] h = new int[t+1];
            int min=1000000000;
            int max=-1;
            int act=Integer.parseInt(st.nextToken());
            h[0]=act;
            int ant=-1;
            for(int i=1;i<t+1;i++){
                ant=act;
                act =Integer.parseInt(st.nextToken());
                int a=Math.min(act,ant);
                min=Math.min(a,min);
                max=Math.max(a,max);
                h[i]=act;
            }
            StringBuffer[] todo = new StringBuffer[max-min+1];
            for(int j=0;j<max-min+1;j++){
                todo[j]=new StringBuffer();
            }



            for(int i=0;i<t;i++){
                int a1=h[i];
                int a2=h[i+1];
                if(a1<a2){
                    for(int j=0;j<max-min+1;j++){
                        if(j!=a1-min)todo[j].append(" ");
                    }
                    todo[a1-min].append("/");
                }else if(a1>a2){
                    for(int j=0;j<max-min+1;j++){
                        if(j!=a2-min)todo[j].append(" ");
                    }
                    todo[a2-min].append("\\");
                }else{
                    for(int j=0;j<max-min+1;j++){
                        if(j!=a1-min)todo[j].append(" ");
                    }
                    todo[a2-min].append("_");
                }
            }

            for(int i=max-min;i>=0;i--){
                System.out.println(todo[i].toString().replaceAll("\\s*$",""));
            }
            System.out.println("***");
            t = Integer.parseInt(in.readLine());

        }

    }
}
