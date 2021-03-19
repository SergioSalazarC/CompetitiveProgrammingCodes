package javaapplication3;

import java.util.Scanner;

class Piloto{
        private int posicion;
        private String nombre;
        
        Piloto(int a,String b){
            this.posicion=a;
            this.nombre=b;
        }
        
        @Override
        public String toString(){
            return(posicion+nombre);
        }
    }

public class JavaApplication3 {    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n= in.nextInt();
        while(n!=0){
            boolean valido=true;
            Piloto[] parrilla=new Piloto[27];
            for(int i=1;i<=n;i++){
                int posicion=in.nextInt();
                String nombre = in.nextLine();
                posicion=i+posicion;
                if(posicion>0 && posicion<27 && parrilla[posicion]==null){
                    parrilla[posicion]= new Piloto(posicion,nombre);
                }else{
                    valido=false;
                }
            }
            if(valido){
                for(int j =1;j<=26;j++){
                    if(parrilla[j]!=null){
                        System.out.println(parrilla[j]);
                    }
                }
            }else{
                System.out.println("IMPOSIBLE");
            }
            System.out.println("-----");
            n=in.nextInt();
        }
    }
    
}