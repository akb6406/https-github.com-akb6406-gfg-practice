//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split("\\s+");
            int r = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                int k = 0;
                str = read.readLine().trim().split("\\s+");
                for(int j = 0; j < c; j++){
                  matrix[i][j] = Integer.parseInt(str[k]);
                  k++;
                }
            }
            new Solution().booleanMatrix(matrix);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < r; i++){
                for(int j = 0; j < c; j++){
                    sb.append(matrix[i][j] + " ");
                }
                sb.append("\n"); 
            }
            System.out.print(sb);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to modify the matrix such that if a matrix cell matrix[i][j]
    //is 1 then all the cells in its ith row and jth column will become 1.
    void booleanMatrix(int a[][])
    {
        // code here 
          
    HashSet<Integer> r=new HashSet<>();
    HashSet<Integer> c=new HashSet<>();
    for(int i=0;i<a.length;i++){
        for(int j=0;j<a[0].length;j++){
            if(a[i][j]==1){
                r.add(i);
                c.add(j);
            }
        }
    }
       for(int i:r){
        for(int k=0;k<a[0].length;k++){
        if(a[i][k]==1){
           
            continue;
        }
        a[i][k]=1;}
    }
       for(int i:c){
        for(int k=0;k<a.length;k++){
        if(a[k][i]==1){
           
            continue;
        }
        a[k][i]=1;}
    }
    }
}