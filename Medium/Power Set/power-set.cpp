//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{
	public:
		void generateSubsequences(string s, int index, string current, vector<string>& result) {
        int n = s.length();
        if (index == n) {
            if (!current.empty()) {
                result.push_back(current);
            }
            return;
        }

        generateSubsequences(s, index + 1, current + s[index], result);

        generateSubsequences(s, index + 1, current, result);
    }

    vector<string> AllPossibleStrings(string s){
        vector<string> result;
        generateSubsequences(s, 0, "", result);

        sort(result.begin(), result.end());

        return result;
    }
};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		string s;
		cin >> s;
		Solution ob;
		vector<string> res = ob.AllPossibleStrings(s);
		for(auto i : res)
			cout << i <<" ";
		cout << "\n";

	}
	return 0;
}
// } Driver Code Ends