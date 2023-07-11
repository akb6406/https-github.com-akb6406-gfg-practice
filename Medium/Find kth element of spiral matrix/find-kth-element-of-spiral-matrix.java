//{ Driver Code Starts
import java.util.*;

class Find_Given_Element_Of_Spiral_Matrix 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int arr[][] = new int[1000][1000];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().findK(arr, n, m, k));
		t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    /*You are required to complete this method*/
    int findK(int A[][], int n, int m, int k)
    {
// 	/ 
int nr=0,nc=0,or=n-1,oc=m-1,count=0;
while(oc>=nc&&or>=nr){
    for(int i=nc;i<=oc;i++)
    {
        count++;
        if(count==k){
           return A[nr][i];
        }
    }
    nr++;
    for(int i=nr;i<=or;i++)
    {
        count++;
        if(count==k){
           return A[i][oc];
        }
    }
    oc--;
    for(int i=oc;i>=nc;i--)
    {
        count++;
        if(count==k){
           return A[or][i];
        }
    }
    or--;
    for(int i=or;i>=nr;i--)
    {
        count++;
        if(count==k){
          return A[i][nc];
        }
    }
    nc++;
}
return -1;
    }
}