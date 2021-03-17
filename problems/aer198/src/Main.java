import java.util.*;

public class Main {
    public static void main(String[] Args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String s =in.nextLine();
            Queue<Long> cola = new LinkedList<>();
            Stack<Long> pila = new Stack();
            boolean colaerror=false;
            boolean pilaerror=false;
            for(int i=0;i<s.length();i++){
                char aux = s.charAt(i);
                if(48<=aux && aux<= 57 ){
                    long auxx = aux-48;
                    cola.add(auxx);
                    pila.add(auxx);
                }
                else if(aux == '+'){
                    if(!colaerror){
                        long a=cola.remove();
                        long b=cola.remove();
                        cola.add(a+b);
                    }
                    if(!pilaerror){
                        long a=pila.pop();
                        long b=pila.pop();
                        pila.add(a+b);
                    }
                }else if(aux == '-'){
                    if(!colaerror){
                        long b=cola.remove();
                        long a=cola.remove();
                        cola.add(a-b);
                    }
                    if(!pilaerror){
                        long b=pila.pop();
                        long a=pila.pop();
                        pila.add(a-b);
                    }
                }else if(aux == '*'){
                    if(!colaerror){
                        long a=cola.remove();
                        long b=cola.remove();
                        cola.add(a*b);
                    }
                    if(!pilaerror){
                        long a=pila.pop();
                        long b=pila.pop();
                        pila.add(a*b);
                    }
                }else if(aux == '/'){
                    if(!colaerror){
                        long b=cola.remove();
                        if(b==0){
                            colaerror=true;
                        }else{
                            long a=cola.remove();
                            cola.add(a/b);
                        }
                    }
                    if(!pilaerror){
                        long b=pila.pop();
                        if(b==0){
                            pilaerror=true;
                        }else{
                            long a=pila.pop();
                            pila.add(a/b);
                        }
                    }
                }
                if(pilaerror &&colaerror) break;
            }
            if (pilaerror && colaerror){
                System.out.println("ERROR = ERROR");
            }else if(pilaerror){
                long c = cola.remove();
                System.out.println("ERROR != "+c);
            }else if(colaerror){
                long p =pila.pop();
                System.out.println(p+" != ERROR");
            }else{
                long p=pila.pop();
                long c=cola.remove();
                if(p==c){
                    System.out.println(c+" = "+c);
                }else{
                    System.out.println(p+" != "+c);
                }
            }
        }


    }
}