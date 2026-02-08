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

vector<long long> v;

ll result(int l, int r) {
    if(l == r) {return v[l];}
    int mid = (l + r) / 2;
    ll ret = max(result(l, mid), result(mid+1, r));
    int lo = mid, hi = mid + 1;
    ll height = min(v[lo], v[hi]);
    ret = std::max(ret, height * 2);
    while(l < lo || hi < r) {
        if(hi < r && (lo == l || v[lo - 1] < v[hi + 1])) {
            height = std::min(height, v[++hi]);
        } else {
            height = std::min(height, v[--lo]);
        }
        ret = std::max(ret, height * (hi - lo + 1));
    }
    return ret;
}


int main(){
    fastIO();
    int size;

    while (true) {
        cin>>size;
        if (!size) {break;}
        v.resize(size);
        for(int j=0; j<size; j++) {
            cin>>v[j];
        }
        cout << result(0, size-1) << endl;
    }
    return 0;
}

