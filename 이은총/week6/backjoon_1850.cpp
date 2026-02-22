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
#define MOD 1'000'000'007
using namespace std;

void fastIO() {
    std::ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
}

void result() {
    ll a, b;
    cin>>a>>b;

    ll currGcd = __gcd(a, b);

    while (currGcd--) {
        cout << 1;
    }
    cout << "\n";
}

int main() {
    fastIO();
    result();
    return 0;
}