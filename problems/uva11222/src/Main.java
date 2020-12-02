import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        for(int i=1;i<=k;i++){
            HashSet<Integer> am1 = new HashSet<>();
            HashSet<Integer> am2 = new HashSet<>();
            HashSet<Integer> am3 = new HashSet<>();
            HashSet<Integer> repetidos=new HashSet<>();
            for(int a=0;a<3;a++){
                if(a==0){
                    int f = in.nextInt();
                    for(int p=0;p<f;p++){
                        am1.add(in.nextInt());
                    }
                }
                if(a==1){
                    int f = in.nextInt();
                    for(int p=0;p<f;p++){
                        int aux=in.nextInt();
                        am2.add(aux);
                        boolean esta = am1.contains(aux);
                        if(esta){
                            repetidos.add(aux);
                        }
                    }
                }
                if(a==2){
                    int f = in.nextInt();
                    for(int p=0;p<f;p++){
                        int aux=in.nextInt();
                        boolean esta = am1.contains(aux);
                        esta=esta||am2.contains(aux);
                        am3.add(aux);
                        if(esta){
                            repetidos.add(aux);
                        }
                    }
                }
            }

            for(Integer rep:repetidos){
                am1.remove(rep);
                am2.remove(rep);
                am3.remove(rep);
            }

            int la1=am1.size();
            int la2=am2.size();
            int la3=am3.size();

            System.out.println("Case #"+i+":");

            if(la1>la2 && la1>la3){
                ArrayList list = new ArrayList(am1);
                Collections.sort(list);
                String am =list.toString().replaceAll("\\p{P}","");
                System.out.println(("1 "+la1+" "+am).trim());
            }
            else if(la2>la1 && la2>la3){
                ArrayList list = new ArrayList(am2);
                Collections.sort(list);
                String am =list.toString().replaceAll("\\p{P}","");
                System.out.println(("2 "+la2+" "+am).trim());
            }
            else if(la3>la1 && la3>la2){
                ArrayList list = new ArrayList(am3);
                Collections.sort(list);
                String am =list.toString().replaceAll("\\p{P}","");
                System.out.println(("3 "+la3+" "+am).trim());
            }
            else if(la1==la2 && la1>la3){
                ArrayList list = new ArrayList(am1);
                Collections.sort(list);
                String am =list.toString().replaceAll("\\p{P}","");
                System.out.println(("1 "+la1+" "+am).trim());
                ArrayList lista = new ArrayList(am2);
                Collections.sort(lista);
                String ama =lista.toString().replaceAll("\\p{P}","");
                System.out.println(("2 "+la2+" "+ama).trim());
            }
            else if(la1==la3 && la1>la2){
                ArrayList list = new ArrayList(am1);
                Collections.sort(list);
                String am =list.toString().replaceAll("\\p{P}","");
                System.out.println(("1 "+la1+" "+am).trim());
                ArrayList lista = new ArrayList(am3);
                Collections.sort(lista);
                String ama =lista.toString().replaceAll("\\p{P}","");
                System.out.println(("3 "+la3+" "+ama).trim());
            }
            else if(la2==la3 && la1<la3){
                ArrayList list = new ArrayList(am2);
                Collections.sort(list);
                String am =list.toString().replaceAll("\\p{P}","");
                System.out.println(("2 "+la2+" "+am).trim());
                ArrayList lista = new ArrayList(am3);
                Collections.sort(lista);
                String ama =lista.toString().replaceAll("\\p{P}","");
                System.out.println(("3 "+la3+" "+ama).trim());
            }
            else if(la1==la2 && la1==la3){
                ArrayList listbb = new ArrayList(am1);
                Collections.sort(listbb);
                String ambb =listbb.toString().replaceAll("\\p{P}","");
                System.out.println(("1 "+la1+" "+ambb).trim());
                ArrayList list = new ArrayList(am2);
                Collections.sort(list);
                String am =list.toString().replaceAll("\\p{P}","");
                System.out.println(("2 "+la2+" "+am).trim());
                ArrayList lista = new ArrayList(am3);
                Collections.sort(lista);
                String ama =lista.toString().replaceAll("\\p{P}","");
                System.out.println(("3 "+la3+" "+ama).trim());
            }


        }
    }
}
