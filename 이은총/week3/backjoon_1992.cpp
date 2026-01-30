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
        cout << "(";
        recur(t_i, t_j, sz/2);
        recur(t_i, t_j + sz/2, sz/2);
        recur(t_i + sz/2, t_j, sz/2);
        recur(t_i + sz/2, t_j + sz/2, sz/2);
        cout << ")";
    }
    else {
        cout << targetColor;
    }
}


void result() {
    int n;
    cin>>n;
    v.resize(n, vector<int>(n));
    string row;
    for (int i=0; i<n; i++) {
        cin>>row;
        for (int j=0; j<n; j++) {
            v[i][j] = row[j] - '0';
        }
    }
    recur(0, 0, n);
}


int main(){
    fastIO();
    result();
    return 0;
}

