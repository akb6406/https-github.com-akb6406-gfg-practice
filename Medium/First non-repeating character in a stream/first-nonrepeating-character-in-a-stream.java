//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
        // code here
        List<Character> cache = new ArrayList<Character>();
        
        int seen[] = new int[26];
        char ans[] = new char[A.length()];
        
        for(int i=0;i<A.length();++i){
            char curr = A.charAt(i);
            if(seen[curr - 97] == 0) {seen[curr - 97] = 1; cache.add(curr);}
            else if(seen[curr - 97] == 1) {seen[curr - 97] = 2; cache.remove(cache.indexOf(curr));}
            
            if(cache.size() == 0) ans[i] = '#';
            else ans[i] = cache.get(0);
        }
        
        return String.valueOf(ans);
    }
}