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

    ll arr[sz+1];
    ll dp[sz+1];
    ll res = 0;
    for (int i=1; i<=sz; i++) {
        cin>>arr[i];
    }

    for (int i=1; i<=sz; i++) {
        dp[i] = 1;
        for (int j=i-1; j>=1; j--) {
            if (arr[i] > arr[j]) {
                dp[i] = max(dp[i], dp[j] + 1);
            }
        }
        res = max(dp[i], res);
    }

    cout << res << '\n';

    stack<ll> s;
    for (int i=sz; i>=1; i--) {
        if (dp[i] == res) {
            s.push(arr[i]);
            res--;
        }
    }

    while (!s.empty()) {
        cout << s.top() << ' '; s.pop();
    }
}


int main(){
    fastIO();
    result();
    return 0;
}

