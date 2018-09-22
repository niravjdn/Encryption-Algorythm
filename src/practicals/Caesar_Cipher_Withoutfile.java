package practicals;
import java.util.Scanner;
public class Caesar_Cipher_Withoutfile {

    public static String msg="",enc="",dec="";
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter String :");
        msg = in.nextLine();
        System.out.print(" Enter key :");
        int key = in.nextInt();
        if(msg.isEmpty())
        {
            System.out.println("Message is null ! Try Again");
            main(args);
        }
        else {
            
            System.out.println(" Message After Encryption : "+Encrypt(msg, key));
            System.out.println("Message After Decryption : "+Decrypt(enc, key));
        }
    }
   
    public static String Encrypt(String str, int key){
        for(int i = 0;i< str.length();i++){
            
            char c = str.charAt(i);
            
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
    public static String Decrypt(String str, int key){
        
        for(int i = 0;i< str.length();i++){
            
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
        }  
        return dec;
    }

}
