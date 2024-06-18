import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) 
        {
            numbers.add(i);
        }
        
        k--; // 0-based index로 변환
        
        for (int i = 0; i < n; i++) 
        {
            long cur = fac(n - 1 - i);
            int index = (int) (k / cur);
            answer[i] = numbers.get(index);
            numbers.remove(index);
            k %= cur;
        }
        
        return answer;
    }
    
    public long fac(long n) 
    {
        if (n == 1 || n == 0)
            return 1;
        else
            return n * fac(n - 1);
    }
}
