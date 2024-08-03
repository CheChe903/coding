#include <iostream>
#include <vector>
#include <stack>

using namespace std;


int main() {

	long long n; cin >> n;
	vector<long long> h(n), l(n), r(n);
	stack<pair<long long, long long>> st1, st2;
	for (long long i = 0; i < n; i++)
	{
		cin >> h[i];
		l[i] = i, r[i] = i;
	}
	for (long long i = 0; i < n; i++) 
	{
		while (!st1.empty()) {
			if (st1.top().first > h[i]) {
				l[i] = st1.top().second;
				break;
			}
			else {
				st1.pop();
			}
		}
		st1.push({ h[i], i });
	}
	for (long long i = n - 1; i >= 0; i--) 
	{
		while (!st2.empty()) {
			if (st2.top().first > h[i]) {
				r[i] = st2.top().second;
				break;
			}
			else {
				st2.pop();
			}
		}
		st2.push({ h[i], i });
	}
	long long res = 0;
	for (long long i = 0; i < n; i++) {
		if (i != l[i]) {
			res += (i - l[i] + 1);
		}
		if (i != r[i]) {
			res += (r[i] - i + 1);
		}
	}
	cout << res << endl;
}