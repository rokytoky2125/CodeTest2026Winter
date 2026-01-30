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
#define MOD 1'000'000'000
#define MAX 101
//this is not for development, but for PS.
//this line is super critical for development.

using namespace std;

void fastIO() {
    std::ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
}

void result() {
    int sz;
    cin>>sz;

    ll targetSZ = abs(sz);
    ll dp[targetSZ+1];
    dp[0] = 0, dp[1] = 1;
    for (int i=2; i<=targetSZ; i++) {
        dp[i] = (dp[i-1] + dp[i-2]) % MOD;
    }
    if (sz > 0) {
        cout << 1 << '\n';
        cout << dp[targetSZ] % MOD;
    }
    else if (sz == 0) {
        cout << 0 << '\n';
        cout << dp[0] % MOD;
    }
    else {
        int flag = ((targetSZ & 1) == 1 ? 1 : -1);
        cout << flag << '\n';
        cout << dp[targetSZ] << '\n';

    }
}


int main(){
    fastIO();
    result();
    return 0;
}

