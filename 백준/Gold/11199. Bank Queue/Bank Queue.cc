#include <iostream>
#include <vector>
#include <utility>
#include <algorithm>
#include <queue>
using namespace std;

bool comp(pair<int, int> a, pair<int, int> b)
{

    if (a.second == b.second)
        return a.first < b.first;
    return a.second > b.second;
}
int main(void)
{
    int n, min;
    int answer = 0;
    cin >> n >> min;

    vector<pair<int, int>> v;
    vector<pair <int, int >>v2;
    for (int i = 0; i < n; i++)
    {
        int money, time;
        cin >> money >> time;
        v.push_back(make_pair(money, time));
    }
    sort(v.begin(),v.end() , comp);

    priority_queue<pair<int, int>> p;
    int j = 0;

    for (int i = min - 1; i >= 0; i--)
    {
        while (j < n && v[j].second == i)
        {
            p.push(v[j]);
            j++;
            
        }
        if (!p.empty())
        {
            answer += p.top().first;
            p.pop();
        }
    }
    cout << answer << endl;

    return 0;
}