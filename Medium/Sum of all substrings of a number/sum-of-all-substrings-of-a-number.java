//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    //taking the String
		    String s=sc.nextLine();
		    Solution ob = new Solution();
		    //calling method sumSubstrings() 
		    System.out.println(ob.sumSubstrings(s));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find sum of all possible substrings of the given string.
    public static long sumSubstrings(String s)
    {
    //Your code here
    int  mod=1000000007;
        int n=s.length();
        long []dp=new long[(int)n];
        dp[0]=s.charAt(0)-'0';
        long ans=dp[0];
        for(int i=1;i<n;i++)
        {
            dp[i]=((dp[i-1]*10)%mod+((s.charAt(i)-'0')*(i+1))%mod)%mod;
            ans=(ans+dp[i])%mod;
        }
        return ans;
    }
}