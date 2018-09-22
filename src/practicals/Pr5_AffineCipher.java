package practicals;

import java.util.Scanner;

public class Pr5_AffineCipher {
    static String msg="",enc="",dec="";
    static int a=3,b=8;
    static int s=0,t=0;
    static int a_inv=0;
    public static void main(String[] args) {
        a_inv=findGCDusingExtended(a,26);

        if(a_inv<0)
            a_inv = (a_inv+26)%26;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter String :");
        msg = in.nextLine();
      
        if(msg.isEmpty())
        {
            System.out.println("Message is null ! Try Again");
            main(args);
        }
        else {
            
            System.out.println("Message After Encryption : "+Encrypt(msg));
            System.out.println("Message After Decryption : "+Decrypt(enc));
        }
    }
   
    public static String Encrypt(String str){
       for(int i = 0;i< str.length();i++){
            
            char c = str.charAt(i);
            
            if (Character.isUpperCase(c))
            {
               c = (char) ((((a * (str.charAt(i)-'A')) + b) % 26) + 'A');                               
            }
            else if (Character.isLowerCase(c))
            {
              c = (char) ((((a * (str.charAt(i)-'a')) + b) % 26) + 'a');
            }
            enc+= (char) c;
        }
        return enc;
    }
    public static String Decrypt(String str){
        
        for(int i = 0;i< str.length();i++){
            
            char c = str.charAt(i);
            
            if (Character.isUpperCase(c))
            {
              // c =(char) (((a_inv * ((str.charAt(i) - b)) % 26)) + 'A');  
                c = (char) (mod(a_inv * ( (str.charAt(i)-'A') - b),26) +'A');
            }
            else if (Character.isLowerCase(c))
            {
                c = (char) (mod(a_inv * ( (str.charAt(i)-'a') - b),26) +'a');
            }
            dec+= (char) c;
        }  
        return dec;
    }
    static int findGCDusingExtended(int a,int b)
    {
      
        int q=0,r1=a,r2=b,r=0,s1=1,s2=0,t1=0,t2=1;
        if(r1<r2)
        {
            int temp=r1;
            r1=r2;
            r2=temp;
        }
        while(r2>0)
        {
            q=r1/r2;
            r=r1 - (q*r2);
            r1=r2;
            r2=r;
            
            s=s1 - (q*s2);
            s1=s2;
            s2=s;
            
            t=t1 - (q*t2);
            t1=t2;
            t2=t;
            
        }
        //t1 mod modvala = value of b
        s=s1;
        t=t1;
        //normal return s
        return t;
        }
  static   int mod(int a, int b)
{
    int r = a % b;
    return r < 0 ? r + b : r;
}
    
    }



