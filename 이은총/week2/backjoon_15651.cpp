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

int n, m;

void fastIO() {
    std::ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
}

void recur(int cur_n, int cur_m, string stk) {
    if (cur_m == m) {
        cout << stk << '\n';
        return;
    }

    for (int i=1; i<=n; i++) {
        recur(i, cur_m+1, stk + to_string(i) + ' ');
    }
}


void result() {
    cin>>n>>m;
    recur(0, 0, "");
}


int main(){
    fastIO();
    result();
    return 0;
}

