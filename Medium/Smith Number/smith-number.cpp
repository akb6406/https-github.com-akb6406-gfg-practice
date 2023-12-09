//{ Driver Code Starts

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends

class Solution {
  public:
    vector<int> getPrimes(int range){
        vector<int> primes(range+1, true);
        primes[1] = primes[0] = false;
        for(int i = 0; i*i < primes.size(); i++){
            if(primes[i]){
                for(int j = i*i; j < primes.size(); j += i){ // 4 
                    primes[j] = false;
                }
            }
        }
        return primes;
    }
    int getDigitSum(int n){
        int sum = 0;
        while(n!=0){
            sum += n%10;
            n /= 10;
        }
        return sum;
    }
    int getPrimeSum(vector<int> &primes, int n){
        int sumOfPrimes = 0;
        for(int i = 0; i < primes.size(); i++){
            if(primes[i] && n%i == 0){
                int digitSum = getDigitSum(i);
                while(n%i == 0){
                    sumOfPrimes += digitSum;
                    n /= i;
                }
            }
        }
        return sumOfPrimes;
    }
    int smithNum(int n) {
        // code here
        int sum = getDigitSum(n);
        vector<int> primes = getPrimes(n/2);
        int sumOfPrimes = getPrimeSum(primes,n);
        if(sum == sumOfPrimes)
            return 1;
        return 0;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        
        cin>>n;

        Solution ob;
        cout << ob.smithNum(n) << endl;
    }
    return 0;
}
// } Driver Code Ends