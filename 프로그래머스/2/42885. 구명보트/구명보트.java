import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        int[] my = people;
        boolean []visited = new boolean[people.length];
        
        //30 30 30 30 20 20 20 20 20 10 10 10 10
        Arrays.sort(my);
        
        int start =0;
        int end = my.length-1;
        
        while (start <= end) 
        {
            // 가장 무거운 사람을 구명보트에 태운다
            int curWeight = my[end];
            end--;
            answer++;
            
            // 가장 가벼운 사람과 함께 태울 수 있는지 확인한다
            if (start <= end && curWeight + my[start] <= limit) {
                start++;
            }
        }
        return answer;
    }
}