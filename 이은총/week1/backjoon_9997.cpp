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
#include <numeric>
#define ll long long
#define weight first
#define val second
#define INF 987654321987654321
#define MOD 10
#define MAX 101
//this is not for development, but for PS.
//this line is super critical for development.

using namespace std;

void fastIO() {
    std::ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
}

ll totalRes = 0;
int MAX_SIZE;
vector<ll> v;
void recur(int n, ll currBit) {
    if (n == MAX_SIZE) {
        if (currBit == ((1 << 26) - 1)) { totalRes++; }
        return;
    }
    recur(n+1, currBit | v[n+1]);
    recur(n+1, currBit);
}


ll result() {
    cin>>MAX_SIZE;
    v.resize(MAX_SIZE + 1);

    string target;
    ll strBit;
    for(int i=1; i<=MAX_SIZE; i++) {
        cin>>target;
        strBit = 0;
        for (char j : target) {
            strBit |= 1 << (j - 'a');
        }
        v[i] = strBit;
    }
    recur(0, 0);
    return totalRes;
}


int main(){
    fastIO();
    cout << result() << '\n';
    return 0;
}

