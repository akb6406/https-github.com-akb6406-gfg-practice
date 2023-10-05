//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
            int k = sc.nextInt();
    		System.out.println (new Solution().substrCount (s, k));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    long substrCount (String s, int k) {
        // your code here
       return atmost_k_chr(s, k) - atmost_k_chr(s, k - 1);
    }
    
    long atmost_k_chr(String s, int k){
        
        if(s.length() == 0) return 0;
        
        int chrFre[] = new int [26];
        int distinct = 0;
        
        long count = 0;
        int left = 0;
        
        for(int i = 0; i < s.length(); i++){
            
            chrFre[s.charAt(i) - 'a']++;
            
            if(chrFre[s.charAt(i) - 'a'] == 1) distinct++;
            
            while(distinct > k){
                chrFre[s.charAt(left) - 'a']--;
                
                if(chrFre[s.charAt(left) - 'a'] == 0) distinct--;
                
                left++;
                
            }
            
            count += i - left + 1;
        }
        
        return count;
    }
}