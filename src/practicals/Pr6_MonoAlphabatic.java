package practicals;

import java.util.*;

public class Pr6_MonoAlphabatic {
    static String msg="",enc="",dec="";
    static String cipherlower="ynlkxbshmiwdpjroqvfeaugtzc";
    static String cipherupper= cipherlower.toUpperCase();
    
    public static void main(String[] args) {
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
                c = (char) (cipherupper.charAt(c-'A'));
               
            }
            else if (Character.isLowerCase(c))
            {
                 c = (char) (cipherlower.charAt(c-'a'));
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
               int j;
               for(j=0;j<cipherupper.length() && cipherupper.charAt(j)!=c;j++);
               c = (char) ('A' + j);
            }
            else if (Character.isLowerCase(c))
            {
               int j;
               for(j=0;j<cipherlower.length() && cipherlower.charAt(j)!=c;j++);
               c = (char) ('a' + j);
            }
            dec+= (char) c;
        }  
        return dec;
    }
}
