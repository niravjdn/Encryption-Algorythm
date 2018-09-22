//Pr12 RSA
package practicals;

import java.util.Scanner;

public class RSA2 {

    static int s, t, p, q, n, e, d, fn;
    static String enc="",dec="",msg="";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Enter value of p");
            p = in.nextInt();
        } while (!checkPrime(p));
        do {
            System.out.println("Enter value of q");
            q = in.nextInt();
        } while (!checkPrime(q));
        n = p * q;
        fn = (p-1)*(q-1);
        System.out.println("n is = "+(n));
        System.out.println("Value of phi(n) is = "+fn);
        do {
            System.out.println("Enter value of e such that gcd(e,phi n)=1 and e is less than "+fn);
            e = in.nextInt();
        } while (1!=findGCD(e,fn) || e>=fn);        
        d = findInverseUsingExtended(e,fn); // w.r to phi(n)
        if(d<0)
            d = (d+fn)%fn;
        System.out.println("Public key is (e,n) = {"+e+","+n+"}.");
        System.out.println("Private key is (d,n) = {"+d+","+n+"}.");
        System.out.println("Enter a message less than "+fn);
        int m = 5;//in.nextInt();
        msg = in.next();
        enc = Encrypt(msg);
        dec = Decrypt(enc);
        System.out.println("Encrypted String  is "+enc);
        System.out.println("Decrypted String  is "+dec);
//       for single number
//        System.out.println("Encrypted text is = "+expo_base(m, e, n));
//        System.out.println("Decrypted text is = "+expo_base(expo_base(m, e, n), d, n));
    }

    static int findGCD(int a, int b) {
        //a>b
        int q = 0, r1 = a, r2 = b, r = 0;
        while (r2 > 0) {
            q = r1 / r2;
            r = r1 - (q * r2);
            r1 = r2;
            r2 = r;
        }
        return r1;
    }

    static String Encrypt(String str)
    {
        enc="";
        for(int i=0;i<str.length();i++)
        {                        
            int ch = expo_base(str.charAt(i),e,n);           
            char ans = (char)ch;                                   
            enc += ans+"";
        }
        return enc;
    }
      static String Decrypt(String str)
    {        
        dec="";
        for(int i=0;i<str.length();i++)
        {            
            int ch = expo_base(str.charAt(i),d,n);            
            char ans = (char)ch;           
            dec += ans+"";
        }
        return dec;
    }
    static boolean checkPrime(int n) {
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static int findInverseUsingExtended(int a, int b) {

        int q = 0, r1 = a, r2 = b, r = 0, s1 = 1, s2 = 0, t1 = 0, t2 = 1;
        if (r1 < r2) {
            int temp = r1;
            r1 = r2;
            r2 = temp;
        }
        while (r2 > 0) {
            q = r1 / r2;
            r = r1 - (q * r2);
            r1 = r2;
            r2 = r;

            s = s1 - (q * s2);
            s1 = s2;
            s2 = s;

            t = t1 - (q * t2);
            t1 = t2;
            t2 = t;

        }
        //t1 mod modvala = value of b
        s = s1;
        t = t1;
        //normal return s
        return t;
    }
    static int expo_base(int base,int exp,int n)
    {
        int ans=1;
        while(true)
        {
            if(exp%2==1)
            {
                ans = (ans * base)%n;
                if(ans<0)
                    ans = (ans+n)%n;
            }
            exp = exp >> 1;
            if(exp==0)
                return ans;
            base = (base * base) % n;
        }
    }   
}
