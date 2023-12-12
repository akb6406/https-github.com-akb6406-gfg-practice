//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String inline[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(inline[0]);
            int m = Integer.parseInt(inline[1]);
            String inline1[] = in.readLine().trim().split("\\s+");
            int M[][] = new int[n][m];
            for(int i = 0;i < n*m;i++){
                M[i/m][i%m] = Integer.parseInt(inline1[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.maxGold(n, m, M));
        }
    }
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    public static int findMaxGold(int i, int j, int n, int m, int[][] mat, int[][] dp){
        if(i < 0 || i >= n || j >= m)
            return 0;
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int[][] dirs = new int[][]
            {
                new int[] {-1, 1},
                new int[] {0, 1},
                new int[] {1, 1}
            };
        int max = Integer.MIN_VALUE;
        for(int x = 0; x < 3; x++){
            int ii = i + dirs[x][0];
            int jj = j + dirs[x][1];
            max = Math.max(max, findMaxGold(ii, jj, n, m, mat, dp));
        }
        dp[i][j] = mat[i][j] + max;
        return dp[i][j];
    }
    static int maxGold(int n, int m, int M[][])
    {
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dp[i][j] = -1;
            }
        }
        for(int i = 0; i < n; i++){
            findMaxGold(i, 0, n, m, M, dp);
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            max = Math.max(max, dp[i][0]);
        }
        return max;
    }
}