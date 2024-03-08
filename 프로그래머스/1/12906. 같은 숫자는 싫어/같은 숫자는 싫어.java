import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        Queue<Integer> queue = new LinkedList<>();
        int cur =0;
        int length = arr.length;
        int curint = -1;
        
        for(int i =0; i<length; i++)
        {
            
            if(arr[i] != curint)
            {
                queue.offer(arr[i]);
                curint=arr[i];
            }
            
        }
        answer = new int[queue.size()];
        int k =0;
        while(!queue.isEmpty())
        {
            answer[k]=queue.poll();
            k++;
        }
        return answer;
    }
}