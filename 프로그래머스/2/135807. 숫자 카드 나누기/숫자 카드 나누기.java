//최대공약수를 묻는 문제, -> gcd? 

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int cur = arrayA[0];
        for(int i = 1; i< arrayA.length; i++)
        {
            cur = gcd(cur,arrayA[i]);
        }
       
        int cur2  = arrayB[0];

        for(int i = 1; i< arrayB.length; i++)
        {
            cur2 = gcd(cur2,arrayB[i]);
        }
        
        if(notDivisible(arrayB, cur))
            if(answer < cur)
                answer = cur;

        if(notDivisible(arrayA, cur2))
            if(answer < cur2)
                answer = cur2;

        // 3. 최댓값 반환
        return answer;
    }
    
    public int gcd(int a, int b)
    {
        if(a % b == 0)return b;
        return gcd(b, a % b);
    }
    public boolean notDivisible(int[] arr, int num)
    {
        for(int n : arr)
            if(n % num == 0)
                return false;
        return true;
    }
}