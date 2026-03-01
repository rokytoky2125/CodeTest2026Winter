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
#define MAX 1000000
#define MOD 1000
using namespace std;
using vvll = vector<vector<ll>>;
using pll = pair<ll, ll>;

void getMatMul(vvll &ma, vvll &mb) {
    vvll tmp;
    tmp.resize(ma.size(), vector<ll>(ma[0].size()));
    for(int i = 0; i<ma.size(); i++) {
        for(int j = 0; j<mb[0].size(); j++) {
            for(int k = 0; k<mb.size(); k++) {
                tmp[i][j] += ma[i][k] * mb[k][j];
            }
            tmp[i][j] %= MOD;
        }
    }
    ma = tmp;
}

vvll getPow(ll idx, vvll &v) {
    vvll mat = v;
    vvll ret = v;

    idx--;
    while(idx) {
        if(idx & 1) { getMatMul(ret, mat); }
        getMatMul(mat, mat);
        idx >>= 1;
    }

    return ret;
}

ll getAdd(ll a, ll b) {
    return (a + b) % MOD;
}

ll getMul(ll a, ll b) {
    return ((a % MOD) * (b % MOD)) % MOD;
}

ll getSub(ll a, ll b) {
    ll ret = a-b;
    while(ret < 0) { ret += MOD; }
    return ret;
}

void fastIO() {
    std::ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
}

void result() {
    ll n, b;
    cin>>n>>b;

    vvll v;
    v.resize(n, vector<ll>(n));
    for (int i=0; i<n; i++) {
        for (int j=0; j<n; j++) {
            cin>>v[i][j];
        }
    }

    vvll ret = getPow(b, v);
    for (int i=0; i<n; i++) {
        for (int j=0; j<n; j++) {
            cout << ret[i][j] % MOD << ' ';
        }
        cout << '\n';
    }
}

int main() {
    fastIO();
    result();
    return 0;
}