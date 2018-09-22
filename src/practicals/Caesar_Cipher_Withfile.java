package practicals;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;


public class Caesar_Cipher_Withfile {

    public static String filename = "", enc = "", dec = "";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter FileName :");
        filename = in.nextLine();
        System.out.print("Enter key :");
        int key = in.nextInt();
        if (filename.isEmpty()) {
            System.out.println("FileName is null ! Try Again");
            main(args);
          } 
        else {
            //create file
             Path newFile = Paths.get("encrypted.txt");
             Path newFile2 = Paths.get("decrypted.txt");
             try {
               Files.deleteIfExists(newFile);
               newFile = Files.createFile(newFile);
               Files.deleteIfExists(newFile2);
               newFile2 = Files.createFile(newFile2);
             } 
         catch (IOException ex) {
               System.out.println("Error creating file");
             }
             
            //reading file and encrypting
             Path sourceFile = Paths.get(filename);
            try (BufferedReader reader = Files.newBufferedReader(
                    sourceFile, Charset.defaultCharset())) {
                String lineFromFile = "";
                String contenttobewritten="";
                while ((lineFromFile = reader.readLine()) != null) {
                    contenttobewritten += lineFromFile + "\n";
                }               
                writeInFile(newFile, Encrypt(contenttobewritten, key));
                System.out.println("File has been encrypted successfully");
                
            } catch (IOException exception) {
                System.out.println("Error while reading file");
            } 
            
              //reading file and decrypting
             Path sourceFile2 = Paths.get("encrypted.txt");
            try (BufferedReader reader = Files.newBufferedReader(
                    sourceFile2, Charset.defaultCharset())) {
                String lineFromFile = "";
                String contenttobewritten="";
                while ((lineFromFile = reader.readLine()) != null) {
                    contenttobewritten += lineFromFile + "\n";
                }               
                writeInFile(newFile2, Decrypt(contenttobewritten, key));
                System.out.println("File has been decrypted successfully");
                
            } catch (IOException exception) {
                System.out.println("Error while reading file");
            } 
            
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
    
    static void writeInFile(Path pathofnewfile,String content)
    {
        try(BufferedWriter writer = Files.newBufferedWriter(
        pathofnewfile, Charset.defaultCharset())){
            writer.write(content);
            writer.flush();
            writer.close();
          }
       catch(IOException exception){
            System.out.println("Error writing to file");
          }
    }

}