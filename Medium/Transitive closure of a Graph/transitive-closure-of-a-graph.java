//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            int graph[][] = new int[N][N];
            
            for(int i = 0;i < N;i++)
                {String a[] = in.readLine().trim().split("\\s+");
                for(int j=0;j<N;j++)
                graph[i][j] = Integer.parseInt(a[j]);}
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.transitiveClosure(N, graph);
            for(int i = 0;i < N;i++)
               { for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
            System.out.println();}
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<ArrayList<Integer>> transitiveClosure(int n, int graph[][])
    {
        // code here
        for (int via = 0; via < n; via++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (graph[i][j] == 0 && graph[i][via] == 1 && graph[via][j] == 1) {
						graph[i][j] = 1;
					}
					if (i == j) {
						graph[i][j] = 1;
					}
				}
			}
		}
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> row = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				row.add(graph[i][j]);
			}
			ans.add(row);
		}
		return ans;
    }
}