package practicals;

import java.util.*;

public class Brute_Force_Cipher {
    public static String msg="";
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter String :");
        msg = in.nextLine();
        String str;
        for(int i=0;i<26;i++)
        {
            str=Brute_Force_Attack(msg,i);
            if(str.contains("This") || str.contains("this") || str.contains("and"))
            {
                str += " Done----------------";
            }
            System.out.println(str);            
        }    
    }
 
   public static String Brute_Force_Attack(String str, int key){
        
       String dec="";
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