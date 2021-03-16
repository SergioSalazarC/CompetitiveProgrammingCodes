import java.util.Scanner;
 
public class ConstanteDeKaprekar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, n, num;
        String number;
        
        n = sc.nextInt();
        
        for(i=0; i<n; i++){
            num = sc.nextInt();
            
            if(num == 0){
                System.out.println("8");
            }else{
                while(num<1000){
                    num = num * 10;
                }
 
                number = Integer.toString(num);
 
                System.out.println(Kaprekar(number));
            }
        }
    }
    
    public static int Kaprekar(String num){
        int cont=0;
        
        if(num.equals("6174")){
            return 0;
        }else if(num.charAt(0) == (num.charAt(1)) && (num.charAt(1) == num.charAt(2)) && (num.charAt(2) == num.charAt(3))){
            return 8;
        }else{
            while(!num.equals("6174")){
                String invertedNum;
                int[] aNum = new int[4];
                int i, j, aux, mNum, lNum;
 
                for(i=0; i<num.length(); i++){
                    aNum[i] = num.charAt(i) - '0';
                }
                
                for(i=0; i<aNum.length; i++){
                    for(j=0; j<aNum.length-i-1; j++){
                        if(aNum[j+1] > aNum[j]){
                            aux = aNum[j+1];
                            aNum[j+1] = aNum[j];
                            aNum[j] = aux;
                        }
                    }
                }
 
                num = Integer.toString(aNum[0]) + Integer.toString(aNum[1]) + Integer.toString(aNum[2]) + Integer.toString(aNum[3]);
 
                invertedNum = new StringBuilder(num).reverse().toString();
 
                mNum = Integer.parseInt(num);
                lNum = Integer.parseInt(invertedNum);
 
                num = Integer.toString(mNum - lNum);
                
                cont++;
            }
            
            return cont;
        }
    }
}