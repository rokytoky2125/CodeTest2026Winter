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
#define MOD 100000
#define MAX 100010
//this is not for development, but for PS.
//this line is super critical for development.

using namespace std;

void fastIO() {
    std::ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
}

void result() {
    string s;
    cin >> s;

    if (s.empty()) {
        cout << "Error!";
        return;
    }
    
    if ('A' <= s[0] && s[0] <= 'Z') {
        cout << "Error!";
        return;
    }

    bool has_underscore = false;
    bool has_uppercase = false;

    for (char c : s) {
        if (c == '_') has_underscore = true;
        if (c >= 'A' && c <= 'Z') has_uppercase = true;
    }

    if (has_underscore && has_uppercase) {
        cout << "Error!";
        return;
    }

    if (has_underscore) {
        if (s[0] == '_' || s.back() == '_') {
            cout << "Error!";
            return;
        }
        for (int i = 0; i + 1 < s.size(); ++i) {
            if (s[i] == '_' && s[i + 1] == '_') {
                cout << "Error!";
                return;
            }
        }

        string java_style = "";
        bool capitalize_next = false;
        for (char c : s) {
            if (c == '_') {
                capitalize_next = true;
            } else {
                if (capitalize_next) {
                    java_style += (c - ('a' - 'A'));
                    capitalize_next = false;
                } else {
                    java_style += c;
                }
            }
        }
        cout << java_style;
    } else {
        string cpp_style = "";
        for (char c : s) {
            if (c >= 'A' && c <= 'Z') {
                cpp_style += '_';
                cpp_style += (c + ('a' - 'A'));
            } else {
                cpp_style += c;
            }
        }
        cout << cpp_style;
    }
}

int main() {
    fastIO();
    result();
    return 0;
}