import java.util.HashSet;
import java.util.Scanner;

public class aer633 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        StringBuilder sol = new StringBuilder();
        while(n!=0){
            int repes=0;
            int incompleto=0;
            int pareja=0;
            HashSet<String> mem = new HashSet<>();
            for(int i=0;i<n;i++){
                String animal = in.next();
                if(mem.contains(animal)) repes++;
                else {
                    char sex= animal.charAt(animal.length()-1);
                    if(sex=='o') sex='a';
                    else if(sex=='a') sex='o';
                    String aux = animal.substring(0,animal.length()-1)+sex;
                    if(mem.contains(aux)){
                        pareja++;
                        incompleto--;
                    }
                    else{
                        incompleto++;
                    }
                }
                mem.add(animal);
            }
            sol.append(pareja).append(" ").append(incompleto).append(" ").append(repes).append("\n");
            n=in.nextInt();
        }
        System.out.print(sol);
    }
}
