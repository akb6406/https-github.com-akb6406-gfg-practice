//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            ArrayList<Long> ans = new Solution().nthRowOfPascalTriangle(n);
            printAns(ans);
        }
    }
    public static void printAns(ArrayList<Long> ans) {
        for (Long x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static final long mod= 1000000007;
    ArrayList<Long> nthRowOfPascalTriangle(int n) {
        // code here
        ArrayList<Long> currentRow= new ArrayList<>();
        currentRow.add(1L);
        
        for(int i=1;i<n;i++){
            ArrayList<Long> nextRow= new ArrayList<>();
            nextRow.add(1L);
            for(int j=1;j<i;j++){
                long newValue= (currentRow.get(j-1) + currentRow.get(j))% mod;
                nextRow.add(newValue);
            }
            nextRow.add(1L);
            currentRow= nextRow;
        }
        return currentRow;
    }
}