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

void result() {
    ll n;
    cin>>n;

    string binary;
    while (n) {
        binary += (n & 1) + '0';
        n /= 2;
    }

    ll num = 1;
    ll res = 0;
    for (int i=0; i<binary.size(); i++) {
        res += num * (binary[i] - '0');
        num *= 3;
    }
    cout << res;
}

int main() {
    fastIO();
    result();
    return 0;
}