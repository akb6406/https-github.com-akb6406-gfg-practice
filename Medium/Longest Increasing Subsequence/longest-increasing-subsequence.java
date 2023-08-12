//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
   static int binarySearch(int l, int h, int[] ans, int num)
    {
        while(l <= h)
        {
            int mid = (h-l)/2+l;
            if(ans[mid] == num)
            return mid;
            else if(ans[mid] > num)
            h = mid-1;
            else
            l = mid+1;
        }
        return l;
    }
   static int longestSubsequence(int n, int a[])
    {
        int ans[] = new int[n];
        Arrays.fill(ans, -1);
        int high = 0;
        ans[0] = a[0];
        for(int i=1; i<n; i++)
        {
            int index = binarySearch(0, high, ans, a[i]);
            if(index > high)
            high = index;
            ans[index] = a[i];
        }
        return high+1;
    }
} 