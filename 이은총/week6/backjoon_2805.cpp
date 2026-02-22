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
#define MOD 1'000'000'007
using namespace std;

void fastIO() {
    std::ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
}

ll k, n;
vector<ll> v;


int isPassed(int mid, const vector<ll> & data) {
    ll p_ret = 0;
    for (int i=0; i<k; i++) {
        p_ret += max( data[i] - mid, 0ll);
    }
    return p_ret >= n;
}


int binarySearch(ll high, const vector<ll>& data) {
    ll low = 1;
    ll mid;
    ll res = 0;
    while (low <= high) {
        mid = (low + high) / 2;
        if (isPassed(mid, data)) {
            if (res < mid) {res = mid;}
            low = mid + 1;
        }
        else { high = mid - 1; }
    }
    return res;
}


void result() {
    cin>>k>>n;
    v.resize(k);
    ll currMax = 0;
    for (int i=0; i<k; i++) {
        cin >> v[i];
        currMax = max(currMax, v[i]);
    }

    cout << binarySearch(currMax, v);
}

int main() {
    fastIO();
    result();
    return 0;
}