import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = {};
        
        answer = new int[score.length];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int i =0; i<score.length; i++)
        {
            if(queue.size() >=k)
            {
                queue.offer(score[i]);
                queue.remove();

            }
            else
            {
                queue.offer(score[i]);
            }
            
            answer[i]=queue.peek();
            
        }
        
        return answer;
    }
}