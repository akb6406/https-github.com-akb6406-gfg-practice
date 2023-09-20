//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int d = sc.nextInt();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.rotate (n, d);
            System.out.println(res.get(0));
            System.out.println(res.get(1));
            
           
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    ArrayList<Integer> rotate(int N, int D)
    {
        // your code here
         ArrayList<Integer> result = new ArrayList<>();

        // Ensure that D is within the range [0, 16] to handle edge cases
        D = D % 16;
        
        // Left rotation
        int leftRotated = (N << D) & 0xFFFF | (N >>> (16 - D));
        result.add(leftRotated);
        
        // Right rotation
        int rightRotated = (N >>> D) | (N << (16 - D)) & 0xFFFF; // Mask with 0xFFFF to keep only 16 bits
        result.add(rightRotated);

        return result;
    }
}