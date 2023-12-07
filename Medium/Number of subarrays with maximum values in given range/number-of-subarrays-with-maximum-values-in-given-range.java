//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		while(testcases-- > 0){
		    
		    String line1 = br.readLine();
		    String []element = line1.trim().split(" ");
		    int n = Integer.parseInt(element[0]);
		    int l = Integer.parseInt(element[1]);
		    int r = Integer.parseInt(element[2]);
		    
		    int arr[] = new int[n];
		    
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split(" ");
		    
		    for(int index = 0;index < n; index++){
		        arr[index] = Integer.parseInt(elements[index]);
		    }
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.countSubarrays(arr, n, l, r));
		        
		}
		
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static long countSubarrays(int a[], int n, int L, int R)  
    { 
        // Complete the function
          int z=0,prev=0;
        long ans=0,count=0;
        for(int i=0;i<n;i++){
            if(a[i]<L){
               if(count>0) count+=prev+1;
            }
            else if(a[i]>=L && a[i]<=R){
                prev=z;
                count+=z+1;
            }
            else{
                ans+=count;
                count=0;
                z=-1;
                prev=0;
            }
            z++;
        }
        ans+=count;
        return ans;
    } 
}

