import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        List<Integer> list = new ArrayList<>();
        
        for(int move : moves) {
            int now = -1;
            
            for(int j = 0; j < board.length; j++) {
                if(board[j][move-1] != 0) {
                    now = board[j][move-1];
                    board[j][move-1] = 0;
                    break;
                }
            }
            if(now != -1) {
                list.add(now);
                if(list.size() >= 2 && (list.get(list.size()-1) == list.get(list.size()-2))) {
                    list.remove(list.size()-1);
                    list.remove(list.size()-1);
                    answer+=2;
                }
            }
        }        
        return answer;
    }
}