import java.util.*;
class Solution {
    static boolean visited[] = new boolean[7];
    static HashSet<Integer> hashset =new HashSet<Integer>();
    public int solution(String numbers) {
        int answer = 0;
        dfs(numbers, "", 0);
        
        for(Integer num : hashset)
        {
            System.out.println(num);
            if(isPrime(num))
                answer++;
            
        }
        return answer;
    }
    
    static void dfs(String numbers, String s, int depth)
    {
        if(depth > numbers.length())
            return;
        
        
        for(int i =0; i<numbers.length(); i++)
        {
            if(!visited[i])
            {
                visited[i]=true;
                hashset.add(Integer.parseInt(s + numbers.charAt(i)));
                dfs(numbers, s+numbers.charAt(i), depth+1);
                visited[i]=false;
            }
        }
    }
    static boolean isPrime(int n)
    {
        if(n ==1 || n==0)
            return false;
        
        for(int i =2; i*i<=n; i++)
        {
            if(n%i==0)
                return false;
        }
        return true;
    }
}