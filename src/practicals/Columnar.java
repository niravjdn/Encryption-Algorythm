//columnar transposition
package practicals;
import java.util.*;

public class Columnar {
    public static String msg="",enc="",dec="";
    static int  lenineachcolumn=0;
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter String :");
        msg = in.nextLine();
        System.out.print("Enter key :");
        String keystring = in.next();
        
        
        double k = (double)keystring.length();
        lenineachcolumn = (int)Math.ceil(msg.length()/k);
              
        if(msg.isEmpty())
        {
            System.out.println("Message is null ! Try Again");
        }
        else
        {
            if(msg.length()%keystring.length()!=0)
            {
                int x = keystring.length() - (msg.length()%keystring.length());
                while(x>0)
                {
                    msg += "x";
                    x--;
                }
            }
            System.out.println("Modified message is " + msg);
            System.out.println("Message After Encryption : "+Encrypt(msg, keystring));
            System.out.println("Message After Decryption : "+Decrypt(enc, keystring));
        }
              
    }
  public static String Encrypt(String str, String key){
      
      for(int i=0;i<26;i++)
      {
          for(int j=0;j<key.length();j++)
          {
              char c = (char) (i +97);
              if(key.charAt(j)==c)
              {
                  //logic to add it to enc
                  for(int k=0;k<lenineachcolumn;k++)
                  {
                      enc+= str.charAt(j+(k*key.length()));
                  }
              }
          }
      }
      return enc;
    }
    public static String Decrypt(String str, String key){  
    String strarray[] = new String[str.length()];
    int cnt=0;
    for(int i=0;i<26;i++)
      {
          for(int j=0;j<key.length();j++)
          {
              char c = (char) (i +97);
              if(key.charAt(j)==c)
              {
                  //logic to add it to dec
                  for(int k=0;k<lenineachcolumn;k++)
                  {
                     // dec+= (j+key.length())str.charAt(cnt);
                      strarray[j+(k*key.length())]=String.valueOf(str.charAt(cnt));
                      cnt++;
                  }
              }
          }
      }
    //store from array to string
         while(cnt!=0)
         {
             dec += strarray[str.length()-cnt];
             cnt--;
         }
        return dec;
    }

}

