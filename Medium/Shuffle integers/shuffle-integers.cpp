//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{
	
	
	
	public:
	void shuffleArray(int arr[],int n)
	{
	    // Your code goes here
	     int num = *max_element(arr, arr+n)+1; //taking mod value as max_value+1
	    int ind = n/2;  
	    for(int i = 1;i<n;i+=2){
	        arr[i] += num*(arr[ind]%num); // elements after n/2 are rearranged at odd indexes(0 based)
	        ind++;
	    }
	    ind = 0;
	    for(int  i = 0;i<n;i+=2){
	        arr[i]+=num*(arr[ind]%num); // rearranging the first n/2 element at even places
	        ind++;
	    }
	    for(int i = 0;i<n;i++){
	        arr[i] = arr[i]/num;   // now removing all old values
	    }
	}
		 

};

//{ Driver Code Starts.


int main() 
{
   
   
   	int t;
    cin >> t;
    while (t--)
    {
    	int n;
	    cin>>n;
	    int a[n] ;
	    for(int i=0;i<n;i++)
	    {
	        cin>>a[i];
	    }


       

        Solution ob;
        ob.shuffleArray(a, n);

		for (int i = 0; i < n; i++) 
			cout << a[i] << " ";
    
	
        
	    cout << "\n";
	     
    }
    return 0;
}
// } Driver Code Ends