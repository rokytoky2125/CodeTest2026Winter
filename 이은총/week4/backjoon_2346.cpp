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
#define MOD 1'000'000'000
#define MAX 101
//this is not for development, but for PS.
//this line is super critical for development.

using namespace std;

void fastIO() {
    std::ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
}

void result() {
    int size;
    cin>>size;

    vector<int> v(size);
    vector<bool> v_boom(size);
    for (int i=0; i<size; i++) {
        cin>>v[i];
    }

    int turnCnt = 0;
    int p = 0;
    while (turnCnt < size - 1) {
        cout << (p + 1) << ' ';
        v_boom[p] = true;
        int moveCnt = v[p];
        bool isLeft = moveCnt < 0;
        if (isLeft) {
            while (moveCnt) {
                p = ((p - 1) + size) % size;
                if (!v_boom[p]) { moveCnt++; }
            }
        }
        else {
            while (moveCnt) {
                p = (p + 1) % size;
                if (!v_boom[p]) {moveCnt--;}
            }
        }
        turnCnt++;
    }
    cout << (p + 1) << ' ';
}

int main(){
    fastIO();
    result();
}

