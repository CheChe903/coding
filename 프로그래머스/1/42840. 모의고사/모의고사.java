import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int []one = {1,2,3,4,5};
        int []two = {2,1,2,3,2,4,2,5};
        int []three = {3,3,1,1,2,2,4,4,5,5};
        
        Queue<Integer> queue = new LinkedList<>();
        int a=0;
        int b = 0;
        int c =0;
        
        for(int i =0; i<answers.length; i++)
        {
            int ones = i%one.length;
            int twos = i%two.length;
            int threes = i%three.length;
            if(answers[i]==one[ones])
                a++;
            if(answers[i]==two[twos])
                b++;
            if(answers[i]==three[threes])
                c++;
        }
        int max= Math.max(a, Math.max(b,c));
        
        if(max ==a )
            queue.offer(1);
        if(max ==b)
            queue.offer(2);
        if(max ==c)
            queue.offer(3);
        answer = new int[queue.size()];
        int k=0;
        while(!queue.isEmpty())
        {
            answer[k]= queue.poll();
            k++;
        }
        return answer;
    }
}