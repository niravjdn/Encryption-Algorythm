package practicals;
import java.util.*;


public class Pr4_ExtendedEuclidean {
    static int s=0,t=0;
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("This a program to find Multiplicative of a number using Extended Eclidean Algorithm");
        System.out.println("Enter a number itself : ");
        int no1=in.nextInt();
        System.out.println("Enter modulo number : ");
        int no2=in.nextInt();
        System.out.println("Multiplicative Inverse of " +no1+ " in "  +no2+ " is " + findGCDusingExtended(no1,no2) +" .");
        System.err.println("Multiplicative inverse is 0 means not possible.");
    }   
    static int findGCDusingExtended(int a,int b)
    {
        //a>b
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
        //t1 mod modvala = value of b for global reference
        s=s1;
        t=t1;
    //  return r1; //for gcd
       if(r1==1)
            return t1 < 0 ? t1 + b : t1;
       else
           return 0;//not possible
    }
}
