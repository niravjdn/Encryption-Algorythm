package practicals;
import java.util.*;
public class Pr4_Euclidean {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("This a program to find GCD of two number using Eclidean Algorithm");
        System.out.println("Enter First number : ");
        int no1=in.nextInt();
        System.out.println("Enter Second number : ");
        int no2=in.nextInt();
        System.out.println("Gcd of " +no1+ " and "  +no2+ " is " + findGCD(no1,no2) +" .");
    }   
    static int findGCD(int a,int b)
    {
        //a>b
        int q=0,r1=a,r2=b,r=0;
        while(r2>0)
        {
            q=r1/r2;
            r=r1 - (q*r2);
            r1=r2;
            r2=r;
        }
        return r1;
    }
}
