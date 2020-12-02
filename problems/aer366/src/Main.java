import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int aux=Integer.parseInt(in.readLine().trim());
        while(aux!=0){
            ArrayList<Par> ls = new ArrayList<>();
            for(int i=0;i<aux;i++){
                String next = in.readLine();
                StringTokenizer st = new StringTokenizer(next," ");
                ls.add(new Par(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
            }
            Collections.sort(ls);
            for(int i=0;i<ls.size();i++){
                System.out.println(ls.get(i).toString());
            }
            System.out.println();
            aux=Integer.parseInt(in.readLine().trim());
        }

    }



    static class Par implements Comparable{
        int a;
        int b;

        public Par(int a, int b) {
            this.a=a;
            this.b=b;
        }

        @Override
        public String toString() {
            return (a+" "+b);
        }

        @Override
        public int compareTo(Object o) {
            Par x = (Par) o;
            if(this.a==x.a){
                int aux=this.b-x.b;
                return(aux);
            }else{
                int aux=x.a-this.a;
                return (aux);
            }
        }
    }
}
