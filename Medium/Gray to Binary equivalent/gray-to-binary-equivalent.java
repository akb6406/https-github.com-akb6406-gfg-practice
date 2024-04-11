//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
    
    // function to convert a given Gray equivalent n to Binary equivalent.
    public static int grayToBinary(int n) {
        
        // Your code here
         if(n==0) return 0;
        int a = 0,i = 31;
        for(i=31;i>=0;i--) if((n&(1<<i))!=0) break;
        a = setOne(a,i);
        int j = i;
        i-=1;
        while(i>=0){
            int fromN = (n&(1<<i))!=0?1:0;
            int fromA = (a&(1<<j))!=0?1:0;
            int xor = fromN^fromA;
            if(xor==1) a = setOne(a,i);
            i--;
            j--;
        }
        return a;
    }
    static int setOne(int a,int i){
        return a|(1<<i);
        
    }
       
}



//{ Driver Code Starts.

class GFG {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();//testcases
		while(t-->0){
		    int n = sc.nextInt();//initializing n
		    
		    Solution obj = new Solution();
		    
		    //calling grayToBinary() function
		    System.out.println(obj.grayToBinary(n));
		}
	}
}

// } Driver Code Ends