import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer =0;
        Queue<Integer> server = new LinkedList<>();
        for(int i = players.length-1; i>=0; i--) {            
            while(!server.isEmpty() && server.peek() - i == k) {
                server.poll();
            }
            
            if(players[i] >= m) {
                int neededServer = players[i]/m;
                if(server.size() >= neededServer) {
                    continue;
                }
                else if(server.size() < neededServer) {
                    int need = neededServer - server.size();
                    for(int j=0; j<need; j++) {
                        server.add(i);
                        answer +=1;
                    }
                }
            }
        }
        return answer;
    }
}