//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S1[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            System.out.println(ob.canReach(A,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int canReach(int[] arr, int N) {
        // code here
        int jump= minJumps(arr);
      
      if(jump==-1)
      {
          return 0;
      }
      else
       {
           return 1;
       }
    }
    static int minJumps(int[] arr)
    {
        if(arr[0]==0)
        {
            return 0;
        }
        if(arr.length==1)
        {
            return 0;
        }
        int n=arr.length;
       //three variables we need to mintain
       int maxR=arr[0];
       int step=arr[0];
       int jump=1;
       for(int i=1;i<arr.length;i++)
       {
           if(i==n-1)
           {
               return jump;
           }
           maxR=Math.max(maxR,i+arr[i]);
           step--;
           if(step==0)
           {
               jump++;
               if(i>=maxR)
               {
                   return -1;
               }
               step=maxR-i;
           }
       }
       return -1;
    }
};