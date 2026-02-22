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
#define MAX 100010
#define MOD 10'007
using namespace std;


ll modpow(ll base, ll exp) {
    ll res = 1;
    while (exp) {
        if (exp & 1) res = res * base % MOD;
        base = base * base % MOD;
        exp >>= 1;
    }
    return res;
}

ll modinv(ll x) {
    return modpow(x, MOD - 2);
}

ll ncr(ll N, ll K) {
    if (K < 0 || K > N) return 0;
    if (K == 0 || K == N) return 1;
    K = min(K, N - K);
    ll res = 1;
    for (ll i = 1; i <= K; ++i) {
        res = res * (N - i + 1) % MOD;
        res = res * modinv(i) % MOD;
    }
    return res;
}

void fastIO() {
    std::ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
}

void result() {
    ll n, k;
    cin>>n>>k;
    cout << ncr(n, k) << "\n";
}

int main() {
    fastIO();
    result();
    return 0;
}