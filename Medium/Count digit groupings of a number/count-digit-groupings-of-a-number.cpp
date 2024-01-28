//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{
	public:
	int f(int ind, int prev , string str,vector<vector<int>>&dp){
        if(ind>=str.size())return 1 ;
        if(dp[ind][prev+1]!=-1)return dp[ind][prev+1] ;
        int ans =0 ;
        for(int i=1;i<=str.size()-ind;i++){
            // considering substring starting at index ind and length i
            string sub_string = str.substr(ind,i) ;
            int sum=0 ;
            for(int j=0;j<sub_string.size();j++)sum+= (sub_string[j]-'0') ;
            if(sum>=prev){
                ans+= f(ind+i , sum, str,dp) ;
            }
        }
        return dp[ind][prev+1] = ans ;
    }
    int TotalCount(string str){
        // Code here
        int n=str.size() ;
        vector<vector<int>>dp(n+1 , vector<int>(901 , -1)) ;
        return f(0 , -1 , str,dp) ;
    }

};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		string str;
		cin >> str;
		Solution ob;
		int ans = ob.TotalCount(str);
		cout << ans <<"\n";
	}
	return 0;
}
// } Driver Code Ends