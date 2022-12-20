import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class aer570 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<Character,Integer> letras = new HashMap<>();
        char[] aux = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        for(int i=0;i<23;i++){
            letras.put(aux[i],i);
        }

        for(int i=0;i<n;i++){
            StringBuffer dni= new StringBuffer(in.next());
            dni.reverse();
            int resto = letras.get(dni.charAt(0));
            int numero = 0;
            LinkedList<Integer> inter=new LinkedList<>();
            for(int j=1;j<9;j++){
                if(dni.charAt(j)=='?'){
                    inter.add(j-1);
                }else{
                    numero+=((dni.charAt(j)-48)*(Math.pow(10,j-1)));
                }
            }
            numero=numero%23;
            HashMap<Integer,Integer> posibles = new HashMap<>();
            posibles.put(numero,1);
            int it=1;
            for(Integer m:inter){
                HashMap<Integer,Integer> auxiliar = new HashMap();
                for(Integer k:posibles.keySet()){
                    for(int j=0;j<10;j++){
                        int nuevo = (int) ((k+j*Math.pow(10,m))%23);
                        if(auxiliar.containsKey(nuevo)){
                            auxiliar.put(nuevo,auxiliar.get(nuevo)+posibles.get(k));
                        }
                        else{
                            auxiliar.put(nuevo,posibles.get(k));
                        }
                    }
                }
                posibles=auxiliar;

            }




            System.out.println(posibles.get(resto));

        }

    }
}