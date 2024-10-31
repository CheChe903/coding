import java.util.*;

class Solution {
    
    static HashMap<Long,Long> map = new HashMap<>();
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        
        for(int i = 0;i <answer.length; i++) {
            answer[i] = findEmptyRoom(room_number[i]);
        }
        return answer;
    }
    
    static long findEmptyRoom(long wantRoom) {
        
        if(!map.containsKey(wantRoom)) {
            map.put(wantRoom, wantRoom+1);
            return wantRoom;
        }
        
        long emptyRoom = findEmptyRoom(map.get(wantRoom));
        map.put(wantRoom, emptyRoom);
        return emptyRoom;
    }
}