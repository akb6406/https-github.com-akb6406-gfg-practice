//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function template for C++
class Solution{
public:
	
	int kSubstrConcat (int n, string s, int k)
	{
	    // Your Code Here
	       if(n%k!=0)return 0;
    map<string,int>m;
    string st;
    int t=0;
     for(int i=0;i<n;i=i+k)
    {
        st="";
         for(int j=0;j<k;j++)
    {
        st+=s[i+j];
    }
      m[st]++;  
    }
    if(m.size()>2 )
    {
        return 0;
    }
     if(m.size()==2)
    {
        for(auto x:m)
        {
            if(x.second>1&&t==0)
            {
                t=1;
                
            }
            else if(x.second>1&&t==1)
            {
                
                    return 0;
            }
        }
    }
    return 1;
	}
};

//{ Driver Code Starts.

int main()
{
    int t; cin >> t;
    while (t--)
	{
		int n; cin >> n;
		string s; cin >> s;
		int k; cin >> k;
        Solution  ob;
		cout << ob.kSubstrConcat (n, s, k) << endl;
	}
}
// } Driver Code Ends