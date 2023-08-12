//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution {
    static int nthFibonacci(int n){
        // code here
        if(n<3) return 1 ;
        // return (nthFibonacci(n-1)+nthFibonacci(n-2))%1000000007;
        return f(n);
    }
    public static int f(int n){
        int dp[]= new int[n];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<n;i++){
            dp[i]= (dp[i-1]+dp[i-2])%1000000007;
        }
        return dp[n-1];
    }
    
}