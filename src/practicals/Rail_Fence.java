package practicals;

import java.util.Scanner;


public class Rail_Fence {
    static String enc="",dec="",msg="";
    static int div=0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter String :");
        msg = in.nextLine();
        System.out.print("Enter Fence value :");
        int key = in.nextInt();
        if(msg.isEmpty())
        {
            System.out.println("Message is null ! Try Again");
        }
        else {
            msg = msg.replaceAll("\\s","");
            int x = key - (msg.length()%key);
            while(x!=0)
            {
                msg+="x";
                x--;
            }
            
        }
        System.out.println("Message After Encryption : "+Encrypt(msg, key));
        System.out.println("Message After Decryption : "+Decrypt(enc, key));
    }
    public static String Encrypt(String str, int key){
        
        double k = (double)key;
        
        div = (int)Math.ceil(str.length() / k);
        for(int i=0;i<key;i++)
        {
            for(int j=0;j<div;j++)
            {
                
                    if((i+(j*key))<str.length())
                        enc+=str.charAt(i+(j*key));
            }
        }
        return enc;
    }
    public static String Decrypt(String str, int key){
       for(int i=0;i<div;i++)
        {
            for(int j=0;j<key;j++)
            {
               if((i+(j*div))<str.length())
               {
                   dec += str.charAt(i+(j*div));
               }
               
            }
        }
        return dec;
    }

}
