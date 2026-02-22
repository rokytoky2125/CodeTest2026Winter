#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>
#include <queue>
#include <set>
#include <unordered_set>
#include <unordered_map>
#include <tuple>
#include <map>
#include <string>
#include <cmath>
#define ll long long
#define weight first
#define val second
#define INF 987654321987654321
#define MOD 100000
#define MAX 100010
//this is not for development, but for PS.
//this line is super critical for development.

using namespace std;

ll n;
void fastIO() {
    std::ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
}

void result() {
    cin>>n;
    vector<ll> dp;
    dp.resize(n+1);

    for (int i=0; i<=n; i++) {
        dp[i] = i;
    }

    for (ll i=1; i<=n; i++) {
        dp[i] = i;
        for (ll j=1; j*j <= i; j++) {
            dp[i] = min(dp[i], dp[i - j*j]+1);
        }
    }

    cout << dp[n];
}


int main(){
    fastIO();
    result();
    return 0;
}

