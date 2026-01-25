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

void fastIO() {
    std::ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
}

bool recur(int col, int row, int div) {
    if (col/div == 1 && row/div == 1) {
        return false;
    }
    if (col < 3 && row < 3) {
        return !(col == 1 && row == 1);
    }
    return recur(col % div, row % div, div/3);
}


void result() {
    int n;
    cin>>n;

    for (int i=0; i<n; i++) {
        for (int j=0; j<n; j++) {
            cout << (recur(i, j, n/3) ? '*' : ' ');
        }
        cout << '\n';
    }
}


int main(){
    fastIO();
    result();
    return 0;
}

