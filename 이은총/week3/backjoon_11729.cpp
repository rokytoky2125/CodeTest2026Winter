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

void recur(int n, int start, int mid, int to) {
    if (n == 1) {
        cout << start << ' ' << to << '\n';
        return;
    }

    recur(n-1, start, to, mid);
    cout << start << ' ' <<to << '\n';
    recur(n-1, mid, start, to);
}


void result() {
    cin>>n;
    cout << pow(2, n) - 1 << '\n';
    recur(n, 1, 2, 3);
}


int main(){
    fastIO();
    result();
    return 0;
}

