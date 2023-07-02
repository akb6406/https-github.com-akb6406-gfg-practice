//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line[] = in.readLine().trim().split("\\s+");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            int l = Integer.parseInt(line[2]);
            int r = Integer.parseInt(line[3]);
            
            Solution ob = new Solution();
            System.out.println(ob.setSetBit(x, y, l, r));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int setSetBit(int x, int y, int l, int r){
        // code here
        int ans = 0;
        for(int i=0; i<32; i++){
            
            if(i>=l-1 && i<=r-1){
                int b1 = (1<<i) & y;
                int b2 = (1<<i) & x;
                if(b1 != 0 || b2 !=0) ans += (1<<i);
            }
            else{
                if( ((1<<i) & x) !=0)
                ans += (1<<i);
            }
        }
        return ans;
    }
}