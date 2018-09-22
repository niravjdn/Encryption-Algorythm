//Fermat Theorm
package practicals;

import java.util.Scanner;

public class Fermat_Theorm {
    public static void main(String[] args)
    {
        int[] primetestedbyfermat = new int[1000];
        int m=0,n=0;
        int[] primefailedbyfermat = new int[1000];
        Scanner in = new Scanner(System.in);
        int i =1,j=0;
        while(i<=1000)
        {
            boolean b1 = test_Fermat(i);
            boolean b2 = test_Prime(i);
            if(b2 && b1)
            {
               primetestedbyfermat[m++]=i;
            }
            else if(b1 && (!b2)) //fermat gives  prime but it is not prime
            {
                primefailedbyfermat[n++]=i;
            }
            i++;
        }
        System.out.println("List of numbers successfully tested by Fermat's Theorm.");
        for(i=0;i<m;i++)
        {
            if(j<5)
            {
                System.out.print(primetestedbyfermat[i]+"\t");   
                j++;
            }
            else
            {
                System.out.print(primetestedbyfermat[i]+"\n"); 
                j=0;
            }
        }
        j=0;
        System.out.println("\nList of numbers failed by Fermat's Theorm.");
        for(i=0;i<n;i++)
        {
            if(j<5)
            {
                System.out.print(primefailedbyfermat[i]+"\t");   
                j++;
            }
            else
            {
                System.out.print(primefailedbyfermat[i]+"\n"); 
                j=0;
            }
        }
    }
     static int expo_base(int base,int exp,int n)
    {
        int ans=1;
        while(true)
        {
            if(exp%2==1)
            {
                ans = (ans * base)%n;
            }
            exp = exp >> 1;
            if(exp==0)
                return ans;
            base = (base * base) % n;
        }
    } 
     static boolean test_Fermat(int p)
     {
         int a=2,ans=0;
           
                ans = expo_base(a,p-1,p);
                if(ans!=1)
                {
                    return false;
                }
                
            return true; //probably prime
     }
      static boolean test_Prime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }   
        return true;
    }
}
