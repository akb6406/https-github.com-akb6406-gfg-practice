//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int matrix[][] = new int[n][n];
            
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                  matrix[i][j] =sc.nextInt();
            }
            Solution ob = new Solution();
            System.out.println(ob.determinantOfMatrix(matrix, n));
        }
    }
}
// } Driver Code Ends




class Solution
{
    //Function for finding determinant of matrix.
    static int determinantOfMatrix(int matrix[][], int n)
    {
        // code here 
 if(n == 1){
            return matrix[0][0];
        }
        //Base Case : if the matrix is 2 * 2, return the determinant 
        if(n == 2){
            return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
        }
        
        int det = 0;
        
        for(int j = 0; j < n; j++){
            det += matrix[0][j] * cofactor(matrix, n,0,j);
        }
        
        return det;
    }
    
    //Helper Function : To Calculate the cofactor of a matrix
    static int cofactor(int matrix[][], int n, int row, int col){
        int[][] submatrix = new int[n-1][n-1];
        int submatrixrow = 0, submatrixcol = 0;
        
        //Create the submatrix by excluding the current row and column
        for(int i = 0; i < n; i++){
            if(i != row){
                submatrixcol = 0;
                for(int j = 0; j < n; j++){
                    if(j != col){
                        submatrix [submatrixrow][submatrixcol] = matrix[i][j];
                        submatrixcol++;
                    }
                }
                submatrixrow++;
            }
        }
        
        //Calculate and return the determinant of the submatrix 
        return (int) Math.pow(-1, row + col) * determinantOfMatrix(submatrix , n - 1);
    }
}

