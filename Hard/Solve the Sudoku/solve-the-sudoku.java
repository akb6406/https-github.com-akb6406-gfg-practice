//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                grid[i][j] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            if(ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();
            
        }
    }
}




// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find a solved Sudoku. 
    static boolean SolveSudoku(int grid[][])
    {
          return solve(0,0,grid);
    }
    
    static boolean solve(int i,int j,int grid[][]){
        if(j==9){
            i++;
            j=0;
        }
        if(i==9 && j==0)    return true;
        if(grid[i][j]!=0)   return solve(i,j+1,grid);
        
        for(int x=1;x<=9;x++){
            if(valid(i,j,x,grid)){
                grid[i][j]=x;
                if(solve(i,j+1,grid))   return true;
                grid[i][j]=0;
            }
        }
        return false;
    }
    
    static boolean valid(int i,int j,int x,int grid[][]){
        //same row
        for(int k=0;k<9;k++){
            if(grid[i][k]==x)   return false;
        }
        
        //same column
        for(int k=0;k<9;k++){
            if(grid[k][j]==x)   return false;
        }
        
        //current box
        for(int k=0;k<3;k++){
            for(int m=0;m<3;m++){
                int ni = i - i%3 + k;
                int nj = j - j%3 + m;
                // System.out.println(ni+" "+nj);
                if(grid[ni][nj]==x)   return false;
            }
        }
        
        return true;
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        for(int i[]:grid){
            for(int j:i){
                System.out.print(j+" ");
            }
        }
    }
}