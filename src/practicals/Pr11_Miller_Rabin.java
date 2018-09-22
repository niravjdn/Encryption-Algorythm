//Pr11_Miller_Rabin

package practicals;
import java.util.Scanner;


public class Pr11_Miller_Rabin
 {
    static int cnt1=0,cnt2=0;
    public static void main(String[] args)
    {
        int[] primetestedbymiller = new int[2000];
        int m=0,n=0;
        int[] primefailedbymiller = new int[2000];
        int[] temp = new int[2000];
        
        Scanner in = new Scanner(System.in);
        System.out.println("Enter value of a as a base");
        int a = in.nextInt();
        int i =1,j=0,k=0;
        while(i<=3000)
        {            
            boolean b1 = test_Miller(i,a);
            boolean b2 = test_Prime(i);
            if(b2 && b1)
            {
               primetestedbymiller[m++]=i;
            }
           else if((!b2 && b1)) //Miller-rabin gives  prime but it is not prime
            {
                primefailedbymiller[n++]=i;
                cnt2++;
            }
           else if((b2 && !b1)) //Miller-rabin gives  prime but it is not prime
            {
                System.err.println("a is equal to p && p>2 && p is prime =>  "+a+"==" +i+" (gives composite but prime)");
            }
            i++;            
        }
        
        System.err.println("total prime " +cnt1);
        System.err.println("total prime failed(gives prime but not prime) " +cnt2);
        
        System.out.println("List of numbers successfully tested by Miller-Rabin's Theorm.");
        for(i=0;i<m;i++)
        {
            if(j<5)
            {
                System.out.print(primetestedbymiller[i]+"\t");   
                j++;
            }
            else
            {
                System.out.print(primetestedbymiller[i]+"\n"); 
                j=0;
            }
        }
        j=0;
        System.out.println("\nList of numbers failed by Miller-Rabin's Theorm.");
        for(i=0;i<n;i++)
        {
            if(j<5)
            {
                System.out.print(primefailedbymiller[i]+"\t");   
                j++;
            }
            else
            {
                System.out.print(primefailedbymiller[i]+"\n"); 
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
     static boolean test_Miller(int p,int a)
     {
         //a is base
         if (p == 0 || p == 1)
            return false;
        if (p == 2)
            return true;        
        if (p % 2 == 0)
            return false; 
        
         int q = p-1;
         int m = 0;
         int k=0;
         while(q%2==0)
         {
                k++;
                q = q/2;
                m = (int)(p / Math.pow(2,k));  
         }
      
                
         int t = expo_base(a, m, p);
      
         //this algo will give non prime if no is prime when a==p         
         if(t==1 || t==-1 || t==(p-1))
         {
             return true;
         }
         
       
        for(int i=1;i<=k-1;i++)
        {
            t = expo_base(t, 2, p);          
            if(t==1)
                return false;
            if(t==-1 || t==(p-1))
                return true;
        }
        return false;
     }

      static boolean test_Prime(int n) {
          if(n==1 || n==1)
              return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }   
        cnt1++;
        return true;
    }
}
