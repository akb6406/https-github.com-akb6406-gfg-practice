//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    int smallestSubstring(string S) {
        // Code here
          int i = 0;
        int j = 0;
        int c[3] = {};
        int n = S.size();
        int result = 1e9;
        while(j <= n && i < n){
            if(c[0] == 0 || c[1] == 0 || c[2] == 0) {
                c[S[j] -'0']++;
                j++;
            }
            else{
                result = min(result, j-i);
                c[S[i] -'0']--;
                i++;
            }
        }
        if(result == 1e9) return -1;
        return result;
    }
};


//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        string S;
        cin >> S;
        Solution ob;
        cout << ob.smallestSubstring(S);
        cout << endl;
    }
}
// } Driver Code Ends