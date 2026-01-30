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

int c_m1, c_0, c_p1;
vector<vector<int>> v;
int white = 0;
int blue = 0;
void recur(int t_i, int t_j, int sz) {

    bool getCut = false;
    int targetColor = v[t_i][t_j];
    for (int i=t_i; i<t_i + sz;i++) {
        for (int j=t_j; j<t_j + sz ; j++) {
            if (v[i][j] !=targetColor) {
                getCut = true;
                break;
            }
        }
    }

    if (getCut) {
        recur(t_i, t_j, sz/3);
        recur(t_i, t_j + sz/3, sz/3);
        recur(t_i, t_j + 2 * sz/3, sz/3);
        recur(t_i + sz/3, t_j, sz/3);
        recur(t_i + sz/3, t_j + sz/3, sz/3);
        recur(t_i + sz/3, t_j + 2* sz/3, sz/3);
        recur(t_i + 2 * sz/3, t_j, sz/3);
        recur(t_i + 2 * sz/3, t_j + sz/3, sz/3);
        recur(t_i + 2 * sz/3, t_j + 2*sz/3, sz/3);
    }
    else {
        if (targetColor == -1) {c_m1++;}
        else if (targetColor == 0) {c_0++;}
        else {c_p1++;}
    }
}


void result() {
    int n;
    cin>>n;
    v.resize(n, vector<int>(n));
    string row;
    for (int i=0; i<n; i++) {
        for (int j=0; j<n; j++) {
            cin>>v[i][j];
        }
    }
    c_m1 = c_0 = c_p1 = 0;
    recur(0, 0, n);
    cout << c_m1 << '\n';
    cout << c_0 << '\n';
    cout << c_p1 << '\n';
}


int main(){
    fastIO();
    result();
    return 0;
}

