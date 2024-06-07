import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        
        for(int i =0; i<targets.length; i++)
        {
            int cur = targets[i][1];

            while(i +1 <targets.length && cur > targets[i+1][0])
            {
                i++;
            }
            answer++;
        }
        return answer;
    }
}