//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int arr[])
    {
        // code here
        int sum=0;
        for(int i=0;i<N;i++){
            sum+=arr[i];
        }
        if(sum%2!=0){
            return  0;
        }
        int target= sum/2;
        int dp[][]= new int[N+1][target+1];
        for(int row[]:dp){
            Arrays.fill(row, -1);
        }
        return f(N-1,arr,target, dp);
    }
     public static int f(int ind, int arr[], int target, int dp[][]){
         if(ind==0) return target==arr[0]? 1:0;
         if(target==0) return 0;
         if(dp[ind][target]!=-1) return dp[ind][target];
         int notTake = f(ind-1, arr, target, dp);
         int take= 0;
         if(target>=arr[ind]){
             take= f(ind-1, arr,target-arr[ind], dp);
         }
         return dp[ind][target]= Math.max(take, notTake);
     }
    
}