import java.util.*;


class Solution {
    static int answer;
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        
        for(int i =1; i<=n; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            back(i, n,list, new boolean[n+1], q, ans);
        }
        
        
        return answer;
    }
    
    static void back(int start, int size, List<Integer> list, boolean visited[], int [][] q, int [] ans) {
            
        if(list.size() == 5) {
            if(check(list, q, ans)) {
                answer+=1;
            }
            
            return;
        }
        
        for(int i = start+1; i<=size; i++) {
            if(!visited[i]) {
                visited[i] = true;
                list.add(i);
                back(i, size, list, visited, q, ans);
                visited[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
    
    static boolean check(List<Integer> list, int q[][], int ans[]) {
        boolean check = true;
        
        for(int i =0; i< q.length; i++) {
            int count = 0;
            for(int j =0; j< q[0].length; j++) {
                if(list.contains(q[i][j])) {
                    count+=1;
                }
            }
            
            if(count != ans[i]) {
                check= false;
                break;
            }
        }
        return check;
    }
}