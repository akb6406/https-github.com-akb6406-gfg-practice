//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*; 
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
    		System.out.println (new Solution().colName (n));
        }
        
    }
}

// Contributed By: Pranay Bansal 

// } Driver Code Ends


//User function Template for Java

class Solution
{
    String colName (long n)
    {
        // your code here
        String ans="";
        while(n!=0){
            int mod=(int)(n%26);
            if(mod==0){
                mod=26;
                n=n/26 - 1;
            }else{
                n=n/26;
            }
            mod+=64;
            char c= (char)mod;
            ans= c+ans;
        }
        return ans;
    }
}