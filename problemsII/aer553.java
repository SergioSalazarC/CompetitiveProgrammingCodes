import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class aer553 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int q=Integer.parseInt(st.nextToken());
        while(q!=0){
            ArrayList<IntPair> al = new ArrayList<>();
            for(int i=0;i<q;i++){
                al.add(new IntPair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
            }
            Collections.sort(al);
            Stack<IntPair> stack = new Stack<>();
            stack.push(al.get(0));
            for(int i=1;i<al.size();i++){
                IntPair top = stack.peek();
                if(top.fini<al.get(i).ini){
                    stack.push(al.get(i));
                }
                else if(top.fini<al.get(i).fini){
                    top.fini=al.get(i).fini;
                    stack.pop();
                    stack.push(top);
                }
            }
            int paginas=0;
            while(!stack.isEmpty()){
                IntPair t= stack.pop();
                paginas+=(t.fini-t.ini+1);
            }
            System.out.println(paginas);
            st = new StringTokenizer(in.readLine(), " ");
            q=Integer.parseInt(st.nextToken());

        }
    }

    public static class IntPair implements Comparable {
        int ini;
        int fini;

        public IntPair(int a, int b){
            ini=a;
            fini=b;
        }

        @Override
        public int compareTo(Object o) {
            IntPair i = (IntPair)o;

            return (this.ini-i.ini);
        }
    }
}