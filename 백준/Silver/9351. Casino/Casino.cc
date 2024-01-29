#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;

bool IsPalindrome(string s) {
	int i = 0, j = s.length() - 1;
	while (i < j) {
		if (s[i] != s[j]) {
			return false;
		}
		i++;
		j--;
	}
	return true;
}

void FindLongestPalindrome(string s)
{
    vector <char> k;
    vector <string> count;
    for (int i = 0; i < s.length(); i++)
    {

        k.push_back(s[i]);
    }

    int max = 0;
    reverse(k.begin(), k.end());
    //k는 반대 s는 정상 abbaa aabba
    for (int left = 0; left < s.length(); left++) {
        for (int right = left; right < s.length(); right++) {
            int len = right - left + 1;
            if (len > max) {
                string sub = s.substr(left, len);
                if (IsPalindrome(sub)) {
                    max = len;
                    count.clear();
                    count.push_back(sub);
                }
            }
            else if (len == max) {
                string sub = s.substr(left, len);
                if (IsPalindrome(sub)) {
                    count.push_back(sub);
                }
            }
        }
    }


    if (max == 1)
        return;

    for (int i = count.size() - 1; i >= 0; i--)
    {

        cout << count[i] << endl;
    }
}

int main()
{

    int n;
    vector <string> s;
    cin >> n;
    char buff[1001];

    for (int i = 0; i < n; i++)
    {
        cin >> buff;

        s.push_back(buff);

    }
    for (int i = 0; i < n; i++)
    {
        cout << "Case #" << i + 1 << ":" << endl;


        FindLongestPalindrome(s[i]);
    }

    return 0;


}
