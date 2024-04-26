//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            int[] ans = ob.FindExitPoint(n, m, matrix);
            for (int i = 0; i < ans.length; i++) System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] FindExitPoint(int n, int m, int[][] matrix) {
        // code here
          int i = 0,  j = 0, dir = 0;
        
        while(i < n && j < m && i >= 0 && j >= 0) {
            if(matrix[i][j] == 1) {
                matrix[i][j] = 0;
                dir++;
            }
            
            dir %= 4;
            switch(dir) {
                case 0: j++; 
                        break;
                
                case 1: i++;
                        break;
                
                case 2: j--;
                        break;
                
                case 3: i--;
                        break;
            }
        }
        
        int res[] = new int[2];
        switch(dir) {
            case 1: res[0] = i - 1;
                    res[1] = j;
                    break;
                    
            case 2: res[0] = i;
                    res[1] = j + 1;
                    break;
                    
            case 3: res[0] = i + 1;
                    res[1] = j;
                    break;
        }
        
        if(dir == 0) {
            res[0] = i;
            res[1] = j - 1;
        }
        
        return res;
    
    }
}