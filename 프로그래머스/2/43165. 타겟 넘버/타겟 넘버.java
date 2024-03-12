import java.util.*;

class Solution {
    static int answer;
    static boolean[] visited;
    static int[] mynum;
    static int mytarget;
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        visited = new boolean [numbers.length];
        mynum=numbers;
        mytarget =target;
        
        dfs(0,0);
        
        return answer;
    }
    
    static void dfs(int index, int sum) {
        if (index == mynum.length) {
            if (sum == mytarget) {
                answer++;
            }
            return;
        }
        
        dfs(index + 1, sum + mynum[index]); // 현재 숫자를 더하는 경우
        dfs(index + 1, sum - mynum[index]); // 현재 숫자를 빼는 경우
    }
}