//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int coins[], int N, int sum) {
        // code here.
        return f(N-1, sum, coins);
    }
    // public static long f(int ind, int T, int coins[]){
    //     if(ind==0){
    //         if(T%coins[ind]==0) return 1;
    //         else return 0;
    //     }
    //     long nottake= f(ind-1,T,coins);
    //     long take=0;
    //     if(T>=coins[ind]) take= f(ind, T-coins[ind], coins);
    //     return take+ nottake;
    // }
    // public static long f(int ind, int T, int coins[]){
    //     long dp[][]= new long[ind+1][T+1];
    //     for(long row[]:dp){
    //         Arrays.fill(row,-1);
    //     }
    //     if(ind==0){
    //         if(T%coins[ind]==0) return 1;
    //         else return 0;
    //     }
    //     if(dp[ind][T]!=-1) return dp[ind][T];
    //     long nottake= f(ind-1,T,coins);
    //     long take=0;
    //     if(T>=coins[ind]) take= f(ind, T-coins[ind], coins);
    //     return dp[ind][T]= take+ nottake;
    // }
    public static long f(int ind, int T, int coins[]){
        long dp[][]= new long[ind+1][T+1];
        // for(long row[]:dp){
        //     Arrays.fill(row,0);
        // }
         for(int i=0;i<=ind;i++){
        for(int j=0;j<=T;j++){
              
        if(i==0){
            if(j%coins[i]==0) dp[i][j]= 1;
            else dp[i][j]= 0;
          } else{
              
          
       long nottake=dp[i-1][j];
        long take=0;
        if(j>=coins[i]) take= dp[i][j-coins[i]];
        dp[i][j]= take+ nottake;
        }
        }
         }
        return dp[ind][T];
    }
}