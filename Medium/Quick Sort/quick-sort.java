//{ Driver Code Starts
import java.util.*;
class Sorting
{
	static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    
    // Driver program
    public static void main(String args[])
    {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();

			
			new Solution().quickSort(arr,0,n-1);
			printArray(arr);
		    T--;
		}
} }
// } Driver Code Ends


class Solution
{
    //Function to sort an array using quick sort algorithm.
     public void quickSort(int[] arr, int low, int high) {
        // base case
        if (low >= high)
            return;

        // partition logic
        int p = partition(arr, low, high);

        // recursion call
        quickSort(arr, low, p - 1);
        quickSort(arr, p + 1, high);
    }

    public int partition(int[] arr, int low, int high) {
        // choose pivotElement
        int pivotIndex = low;
        int pivotElement = arr[low];

        // place at right position
        int count = 0;
        for (int i = low + 1; i <= high; i++) {
            if (arr[i] <= pivotElement)
                count++;
        }
        int rightIndex = low + count;
        swap(arr, pivotIndex, rightIndex);
        pivotIndex = rightIndex;

        // left smaller element and right bigger element
        int i = low, j = high;
        while (i < pivotIndex && j > pivotIndex) {
            while (arr[i] <= arr[pivotIndex])
                i++;
            while (arr[j] > arr[pivotIndex])
                j--;
            if (i < j)
                swap(arr, i, j);
        }

        return pivotIndex;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
