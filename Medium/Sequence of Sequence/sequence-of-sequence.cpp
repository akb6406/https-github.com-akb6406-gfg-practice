//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++

class Solution{
public:
   int generate(int a, int m, int n){
        int total = 0;
        int lim = m>>n;
        
        while(a <= lim){
            if(n)
                total += generate(a*2,m,n-1);
            else
                total++;
            a++;
        }
        return total;
    }
    int numberSequence(int m, int n){
        return generate(1,m,n-1);
    }
};

//{ Driver Code Starts.
int main(){
    int t;
    cin>>t;
    while(t--){
        int m, n;
        cin>>m>>n;
        
        Solution ob;
        cout<<ob.numberSequence(m, n)<<endl;
    }
    return 0;
}
// } Driver Code Ends