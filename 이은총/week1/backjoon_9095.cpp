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
#define MOD 1'000'000'009
#define MAX 100'010
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
    dp[1] = 1;
    dp[2] = 1;
    dp[3] = 1;
    for (int i=1; i<MAX-10; i++) {
        dp[i+1] += dp[i];
        dp[i+2] += dp[i];
        dp[i+3] += dp[i];
    }
}


void result(int x) {
    cout << dp[x] << '\n';
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

