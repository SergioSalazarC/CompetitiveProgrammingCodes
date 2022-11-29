import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class aer389 {

    static int[] dicc;
    static boolean[] usado;
    static String s;

    static int indicefinalop1;
    static int indicefinalop2;
    static int indicefinalsol;


    static boolean resolver_suma(int indice, int acarreo,String op1, String op2, String sol){
        if(indice>=op1.length()){
            if(acarreo!=0) return false;
            else{
                //COMPROBAMOS QUE LAS ULTIMAS CIFRAS NO SEAN CEROS
                if(dicc[op1.charAt(indicefinalop1)]==0) return false;
                if(dicc[op2.charAt(indicefinalop2)]==0) return false;
                if(dicc[sol.charAt(indicefinalsol)]==0) return false;

                //HEMOS LLEGADO A UNA SOLUCIÓN
                StringBuilder solucion = new StringBuilder();
                for (int i = 0; i < s.length(); i++) {
                    char z= s.charAt(i);
                    if(97<=z && z<=122) solucion = solucion.append(dicc[z]);
                    else solucion = solucion.append(z);
                }
                System.out.println(solucion);
                return true;
            }

        }
        else{
            //a+b+^=c
            char lop1 = op1.charAt(indice);
            char lop2 = op2.charAt(indice);
            char lsol = sol.charAt(indice);
            if(dicc[lop1]!=-1 && dicc[lop2]!=-1 && dicc[lsol]!=-1){
                if((dicc[lop1]+dicc[lop2]+acarreo)%10 == dicc[lsol]) return resolver_suma(indice+1,(dicc[lop1]+dicc[lop2]+acarreo)/10,op1,op2,sol);
                else return false;
            }
            else{
                boolean devolver = false;
                if(dicc[lop1]==-1){
                    for (int i = 0; i < 10 && !devolver; i++) {
                        if(usado[i])continue;
                        dicc[lop1]=i;
                        usado[i]=true;
                        devolver = devolver || resolver_suma(indice,acarreo,op1,op2,sol);
                        dicc[lop1]=-1;
                        usado[i]=false;
                    }
                }
                else if(dicc[lop2]==-1){
                    for (int i = 0; i < 10 && !devolver; i++) {
                        if(usado[i])continue;
                        dicc[lop2]=i;
                        usado[i]=true;
                        devolver = devolver || resolver_suma(indice,acarreo,op1,op2,sol);
                        dicc[lop2]=-1;
                        usado[i]=false;
                    }
                }
                else{
                    int debe = dicc[lop1] + dicc[lop2] + acarreo;
                    if(usado[debe%10])return false;
                    dicc[lsol]=debe%10;
                    usado[debe%10]=true;
                    devolver = devolver || resolver_suma(indice,acarreo,op1,op2,sol);
                    dicc[lsol]=-1;
                    usado[debe%10]=false;
                }
                return devolver;
            }

        }

    }



    static boolean resolver_prod(int indice, int acarreo,String op1, String op2, String sol){
        if(indice>=op1.length()){
            if(acarreo!=0) return false;
            else{
                //COMPROBAMOS QUE LAS ULTIMAS CIFRAS NO SEAN CEROS
                if(dicc[op1.charAt(indicefinalop1)]==0) return false;
                if(dicc[op2.charAt(indicefinalop2)]==0) return false;
                if(dicc[sol.charAt(indicefinalsol)]==0) return false;

                //HEMOS LLEGADO A UNA SOLUCIÓN
                StringBuilder solucion = new StringBuilder();
                for (int i = 0; i < s.length(); i++) {
                    char z= s.charAt(i);
                    if(97<=z && z<=122) solucion = solucion.append(dicc[z]);
                    else solucion = solucion.append(z);
                }
                System.out.println(solucion);
                return true;
            }

        }
        else{
            char lop1 = op1.charAt(indice);
            char lop2 = op2.charAt(indice);
            char lsol = sol.charAt(indice);
            if(dicc[lop1]!=-1 && dicc[lop2]!=-1 && dicc[lsol]!=-1){
                int debe=0;
                int aux=indice-1;
                for (int i = 0; i < indice; i++) {
                    char a = op2.charAt(i);
                    char b = op1.charAt(aux);
                    aux--;
                    debe+= dicc[a]*dicc[b];
                }
                debe+=acarreo;

                if(dicc[lsol]==debe%10) return resolver_prod(indice+1,debe/10,op1,op2,sol);
                else return false;
            }
            else{
                boolean devolver = false;
                if(dicc[lop1]==-1){
                    for (int i = 0; i < 10 && !devolver; i++) {
                        if(usado[i])continue;
                        dicc[lop1]=i;
                        usado[i]=true;
                        devolver = devolver || resolver_prod(indice,acarreo,op1,op2,sol);
                        dicc[lop1]=-1;
                        usado[i]=false;
                    }
                }
                else if(dicc[lop2]==-1){
                    for (int i = 0; i < 10 && !devolver; i++) {
                        if(usado[i])continue;
                        dicc[lop2]=i;
                        usado[i]=true;
                        devolver = devolver || resolver_prod(indice,acarreo,op1,op2,sol);
                        dicc[lop2]=-1;
                        usado[i]=false;
                    }
                }
                else{
                    //int debe = dicc[lop1] * dicc[lop2] + acarreo;
                    int debe=0;
                    int aux=indice;
                    for (int i = 0; i <= indice; i++) {
                        char a = op2.charAt(i);
                        char b = op1.charAt(aux);
                        aux--;
                        debe+= dicc[a]*dicc[b];
                    }
                    debe+=acarreo;
                    if(usado[debe%10])return false;
                    dicc[lsol]=debe%10;
                    usado[debe%10]=true;
                    devolver = devolver || resolver_prod(indice+1,debe/10,op1,op2,sol);
                    dicc[lsol]=-1;
                    usado[debe%10]=false;
                }
                return devolver;
            }

        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        s = in.readLine();
        while(s!=null){
            StringTokenizer st = new StringTokenizer(s);
            int max = -1;
            StringBuilder op1 = new StringBuilder(st.nextToken()).reverse();
            String simb = st.nextToken();
            StringBuilder op2=new StringBuilder(st.nextToken()).reverse();
            st.nextToken();
            StringBuilder sol = new StringBuilder(st.nextToken()).reverse();
            max = Math.max(max,op1.length());
            max = Math.max(max,op2.length());
            max = Math.max(max,sol.length());
            indicefinalop1=op1.length()-1;
            indicefinalop2=op2.length()-1;
            indicefinalsol=sol.length()-1;
            while(op1.length()!=max){
                op1.append('@');
            }
            while(op2.length()!=max){
                op2.append('@');
            }
            while(sol.length()!=max){
                sol.append('@');
            }

            dicc=new int[123];
            usado =new boolean[10];
            Arrays.fill(dicc,-1);
            dicc['@']=0;

            if(simb.equals("+")){
                resolver_suma(0,0,op1.toString(),op2.toString(),sol.toString());
            }
            else{
                resolver_prod(0,0,op1.toString(),op2.toString(),sol.toString());
            }


            s=in.readLine();
        }
    }

}
