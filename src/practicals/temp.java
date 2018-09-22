/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicals;

import java.nio.file.*;
import java.io.*;
import java.nio.charset.Charset;


/**
 *
 * @author Nirav
 */
public class temp {
    
    public static void main(String[] args)
    {
        System.out.println(expo_base(2,1,3));
        System.out.println(test_Prime(25));
        System.out.println(test_Miller(25,7)); 
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
 static boolean test_Prime(int n) {
          if(n==1 || n==1)
              return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }   
        
        return true;
    }
}