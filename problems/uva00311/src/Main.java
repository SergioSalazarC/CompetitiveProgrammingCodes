import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s1=in.nextInt();
        int s2=in.nextInt();
        int s3=in.nextInt();
        int s4=in.nextInt();
        int s5=in.nextInt();
        int s6=in.nextInt();
        while(s1!=0 || s2!=0 || s3!=0 || s4!=0 || s5!=0 || s6!=0){
            int packs=0;
            while(s6>0){
                packs++;
                s6--;
            }
            while(s5>0){
                packs++;
                s5--;
                s1-=11;
            }
            while(s4>0){
                packs++;
                s4--;
                if(s2>=5){
                    s2-=5;
                }else if(s2>0){
                    s1-=(20-4*s2);
                    s2=0;
                }else{
                    s1-=20;
                }
            }
            while(s3>0){
                packs++;
                if(s3>=4){
                    s3-=4;
                }else if(s3==3){
                    s3=0;
                    if(s2>0){
                        s2--;
                        s1-=5;
                    }else{
                        s1-=9;
                    }
                }else if(s3==2){
                    s3=0;
                    if (s2>=3){
                        s2-=3;
                        s1-=6;
                    }else if(s2>0){
                        s1-=18-4*s2;
                        s2=0;
                    }else{
                        s1-=18;
                    }
                }else if(s3==1){
                    s3=0;
                    if(s2>=5){
                        s2-=5;
                        s1-=7;
                    }else if(s2>0){
                        s1-=27-4*s2;
                        s2=0;
                    }else{
                        s1-=27;
                    }
                }
            }
            while(s2>0){
                packs++;
                if(s2>=9){
                    s2-=9;
                }else{
                    s1-=36-4*s2;
                    s2=0;
                }
            }
            while(s1>0){
                packs++;
                s1-=36;
            }

            System.out.println(packs);
            s1=in.nextInt();
            s2=in.nextInt();
            s3=in.nextInt();
            s4=in.nextInt();
            s5=in.nextInt();
            s6=in.nextInt();

        }


    }
}
