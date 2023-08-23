//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            int[][] ans = obj.searchWord(grid, word);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
            if(ans.length==0)
            {
                System.out.println("-1");
            }

        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    private boolean solve(int a, int b, int k, String word, char[][] grid, int d1, int d2){
        // base case
        int n = grid.length, m = grid[0].length;
        if(k >= word.length())
            return true;
        if(a < 0 || a >= n || b < 0 || b >= m)
            return false;
            
        if(grid[a][b] != word.charAt(k))
            return false;
        else
            return solve(a + d1, b + d2, k + 1, word, grid, d1, d2);
    }
   

public int[][] searchWord(char[][] grid, String word){
        int n = grid.length, m = grid[0].length;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        int[] row = {0, 0, -1, 1, -1, -1, 1, 1};
        int[] col = {-1, 1, 0, 0, -1, 1, 1, -1};
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == word.charAt(0)){
                    for(int k=0; k<8; k++){
                        int x = i + row[k];
                        int y = j + col[k];
                        
                        if(x >= 0 && x < n && y >= 0 && y < m){
                            if(solve(x, y, 1, word, grid, row[k], col[k]) == true){
                                ArrayList<Integer> sub = new ArrayList<>();
                                sub.add(i);
                                sub.add(j);
                                list.add(sub);
                                break;
                            }
                        }
                    }
                }
            }
        }
        
        int[][] ans = new int[list.size()][2];
        for(int i=0; i<list.size(); i++){
            for(int j=0; j<2; j++){
                ans[i][j] = list.get(i).get(j);
            }
        }
        
        return ans;
    }
}