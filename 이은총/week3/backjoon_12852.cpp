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
#define MOD 10
#define MAX 100001
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

    ll dp[sz*3 + 1];
    for (int i=1; i<=sz; i++) {
        dp[i] = INF;
    }

    dp[1] = 0; dp[2] = 1; dp[3] = 1;
    for (int i=2; i<=sz; i++) {
        if (dp[i] == INF) { dp[i] = 0; }
        dp[i+1] = min(dp[i+1], dp[i] + 1);
        dp[i*2] = min(dp[i*2], dp[i] + 1);
        dp[i*3] = min(dp[i*3], dp[i] + 1);
    }

    cout << dp[sz] << '\n';

    ll curr = sz;
    while (curr > 1) {
        cout << curr << ' ';
        if (curr % 3 == 0 && dp[curr/3] == dp[curr] - 1) { curr /= 3; }
        else if (curr % 2 == 0 && dp[curr/2] == dp[curr] - 1) { curr /= 2; }
        else if (dp[curr - 1] == dp[curr] - 1) { curr--; }
    }
    cout << 1;
}


int main(){
    fastIO();
    result();
    return 0;
}

