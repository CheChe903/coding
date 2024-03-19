import java.util.*;

class Solution {
    static int[] visited;
    static String mytarget;
    static String[] mywords;
    static int index;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        visited = new int[words.length];
        
        mytarget = target;
        mywords = words;
        index=-1;
        for(int i =0; i<words.length; i++)
        {
            if(target.equals(words[i]))
                index=i;
        }
        if(index==-1)
            return 0;
        
        bfs(begin);
        for(int i =0; i<visited.length; i++)
        {
            System.out.println(visited[i]);
        }
        answer = visited[index];
        return answer;
    }
    
    static void bfs(String begin)
    {
        Queue<String> queue= new LinkedList<>();
        
        
        queue.add(begin);
        int count =1;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int j =0; j<size; j++)
            {
                String cur = queue.poll();
                for(int i =0; i<mywords.length; i++)
                {


                    if(visited[i]==0 &&equal(cur,mywords[i]))
                    {
                        queue.add(mywords[i]);
                        visited[i]=count;

                    }
                }
            }

            count++;
        }
    }
    static boolean equal(String str1, String str2)
    {
        int cnt =0;
        
        for(int i=0; i<str1.length(); i++)
        {
            if(str1.charAt(i) == str2.charAt(i))
                cnt++;
        }
        if(cnt ==str1.length()-1)
            return true;
        else
            return false;
    }
}