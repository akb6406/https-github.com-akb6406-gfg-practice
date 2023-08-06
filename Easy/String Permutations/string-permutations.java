//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public ArrayList<String> permutation(String S)
    {
        //Your code here
        ArrayList<String> ar= new ArrayList<>();
        String perm= "";
        if(S.length()==0) return ar;
        Permutation(ar, S, perm);
        Collections.sort(ar);
        return ar;
    }
    public void Permutation(ArrayList<String> ar, String S, String perm){
        if(S.length()==0){
            ar.add(perm);
            return ;
        }
        for(int i=0;i<S.length();i++){
            char ch= S.charAt(i);
            String str= S.substring(0,i)+S.substring(i+1);
            Permutation(ar,str, perm+ch);
        }
    }
	   
}
