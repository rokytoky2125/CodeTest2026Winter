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
#define MAX 10000
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
    ll result = 1;
    ll cnt2, cnt5;
    cnt2 = cnt5 = 0;

    for (ll i =1; i<=n; i++) {
        ll tmp = i;
        while (tmp % 2 == 0) {
            cnt2++; tmp /= 2;
        }
        while (tmp % 5 == 0) {
            cnt5++; tmp /= 5;
        }

        result = (result % MOD) * (tmp % MOD);
        result %= MOD;
    }

    ll diff = cnt2 - cnt5;
    if (diff < 0) {
        cnt5 -= cnt2;
        while (cnt5--) {
            result = (result % MOD) * 5;
            result %= MOD;
        }
    }
    else {
        cnt2 -= cnt5;
        while (cnt2--) {
            result = (result % MOD) * 2;
            result %= MOD;
        }
    }

    string res_s = to_string(result);
    ll str_diff = 5 - res_s.size();
    while (str_diff--) { cout << '0'; }
    cout << result;
}


int main(){
    fastIO();
    result();
    return 0;
}

