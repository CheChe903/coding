import java.util.*;



class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> myq1 = new LinkedList<>();
        Queue<Integer> myq2 = new LinkedList<>();
        long sum1=0;
        long sum2 =0;
        long allsum =0;
        for(int i = 0; i<queue1.length; i++)
        {
            myq1.add(queue1[i]);
            myq2.add(queue2[i]);
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        allsum = sum1+ sum2;
        int answer =0;
        int cnt =0;
        while(true)
        {
            int cur =0;
            if(sum1>allsum/2)
            {
                cur =myq1.poll();
                sum1 -= cur;
                myq2.add(cur);
                sum2 +=cur;
                answer++;
            }
            else if(sum2>allsum/2)
            {
                cur = myq2.poll();
                sum2 -= cur;
                myq1.add(cur);
                sum1 += cur;
                answer++;
            }
            
            if(sum1 == sum2)
            {
                return answer;
            }
            else if(answer >queue1.length*2+1)
                return -1;
            
        }
        
    }
}