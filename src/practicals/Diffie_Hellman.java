//diffie hellman
package practicals;

import java.math.BigInteger;
import java.util.Scanner;

public class Diffie_Hellman {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter value of n - huge prime number(prime number)");
        int n1 = in.nextInt(); //public
        System.out.println("Enter value of g - generator(prime number)");
        int g1 = in.nextInt(); //public
        System.out.println("Enter value of x (First Person) - private key of A (<p)");
        int x1 = in.nextInt(); //private key of a
        System.out.println("Enter value of y (Second Person) - private key of B (<p)");
        int y1 = in.nextInt(); //private key of b
        BigInteger n = new BigInteger(String.valueOf(n1));
        BigInteger g = new BigInteger(String.valueOf(g1));
        BigInteger x = new BigInteger(String.valueOf(x1));
        BigInteger y = new BigInteger(String.valueOf(y1));
        
        //compute public key of A
        BigInteger pkeyofA = g.modPow(x,n);
        System.out.println("Public Key of A is "+pkeyofA);
        //compute public key of B
        BigInteger pkeyofB = g.modPow(y,n);
        System.out.println("Public Key of B is "+pkeyofB);
        
        BigInteger k1 = pkeyofB.modPow(x,n);
        BigInteger k2 = pkeyofA.modPow(y,n);
        System.out.println("First Person key is k1 = "+k1);
        System.out.println("Second Person key is k2 = "+k2);
        
    }
  
}
