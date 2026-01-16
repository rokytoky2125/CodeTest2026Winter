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

ll dp[MAX];
void preCalculate() {
    dp[0] = 1;
    dp[1] = 1;
    for (int i=2; i<MAX; i++) {
        dp[i] = dp[i-1] + dp[i-2];
    }
}


void result(int x) {
    if (x == 0) {
        cout <<"1 0"<<'\n';
    }
    else if (x == 1) {
        cout << "0 1" << '\n';
    }
    else {
        cout << dp[x-2] << ' ' << dp[x-1] << '\n';
    }
}


int main(){
    fastIO();

    int testCnt = 0;
    int target;
    preCalculate();
    cin>>testCnt;

    while (testCnt--) {
        cin>>target;
        result(target);
    }

    return 0;
}

