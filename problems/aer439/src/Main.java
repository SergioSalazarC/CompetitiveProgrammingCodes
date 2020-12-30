import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int a=in.nextInt();
        for(int i=0;i<a;i++){
            StringTokenizer st = new StringTokenizer(in.next(),"=");
            String k=st.nextToken();
            if(k.equals("D")){
                StringTokenizer st1 = new StringTokenizer(in.next(),"=");
                String k1=st1.nextToken();
                int u = Integer.parseInt(st.nextToken()) / Integer.parseInt(st1.nextToken());
                if(k1.equals("T")){
                    System.out.println("V="+u);
                }else{
                    System.out.println("T="+u);
                }
            }else if(k.equals("T")){
                StringTokenizer st1 = new StringTokenizer(in.next(),"=");
                String k1=st1.nextToken();
                if(k1.equals("V")){
                    int u= Integer.parseInt(st.nextToken())*Integer.parseInt(st1.nextToken());
                    System.out.println("D="+u);
                }else{
                    int u=Integer.parseInt(st1.nextToken())/Integer.parseInt(st.nextToken());
                    System.out.println("V="+u);
                }
            }else{
                StringTokenizer st1 = new StringTokenizer(in.next(),"=");
                String k1=st1.nextToken();
                if(k1.equals("D")){
                    int u=Integer.parseInt(st1.nextToken())/Integer.parseInt(st.nextToken());
                    System.out.println("T="+u);
                }else{
                    int u=Integer.parseInt(st1.nextToken())*Integer.parseInt(st.nextToken());
                    System.out.println("D="+u);
                }
            }
        }
    }
}
