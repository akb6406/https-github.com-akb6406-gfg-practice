//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG implements Runnable {
    public void run() {
        try {
            BufferedReader in;
            PrintWriter out;
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int t = Integer.parseInt(in.readLine());

            while (t-- > 0) {
                int n = Integer.parseInt(in.readLine().trim());

                Solution g = new Solution();
                out.println(g.countWays(n));
            }
            out.close();
        } catch (Exception e) {
            ;
        }
    }

    public static void main(String args[]) throws IOException {
        new Thread(null, new GFG(), "whatever", 1 << 26).start();
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to count the number of ways in which frog can reach the top.
    static int mod=1000000007;
    static long countWays(int n)
    {
          long[]dp=new long[n+1];
       Arrays.fill(dp,-1);
       
       return solve(0,n,dp);
    }
    static long solve(int s, int n, long dp[]){
        //base case 
        if(s>=n){
            if(s==n){
              return 1;  
            }
            return 0;
        }
       
        if(dp[s]!=-1){
            return dp[s];
        }
        
        long stp1=solve(s+1,n,dp);  //1step jump
        long stp2=solve(s+2,n,dp);  //2step
        long stp3=solve(s+3,n,dp);  //3step
        
        return dp[s]=(stp1%mod+stp2%mod+stp3%mod)%mod;
    }
    
}

