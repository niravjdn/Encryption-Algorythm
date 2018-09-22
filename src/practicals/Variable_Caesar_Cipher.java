package practicals;
import java.util.*;

public class Variable_Caesar_Cipher {
    public static String msg="",enc="",dec="";
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
            int key=2*i+7;
            if (Character.isUpperCase(c))
            {
                c =     (char) (c + (key % 26));
                if (c > 'Z')
                 c = (char) (c - 26);
            }
            else if (Character.isLowerCase(c))
            {
                c = (char) (c + (key % 26));
                if (c > 'z')
                c = (char) (c - 26);
            }
            enc+= (char) c;
         
        }
        return enc;
    }
    public static String Decrypt(String str){
        
        for(int i = 0;i< str.length();i++){
            int key=2*i+7;
            char c = str.charAt(i);
            
            if (Character.isUpperCase(c))
            {
                c =     (char) (c - (key % 26));
                if (c < 'A')
                c = (char) (c + 26);
            }
            else if (Character.isLowerCase(c))
            {
                c = (char) (c - (key % 26));
                if (c < 'a')
                c = (char) (c + 26);
            }
            dec+= (char) c;
            key++;
        }  
        return dec;
    }

}
