import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<String, Integer>();

        // 참가자와 그들의 카운트를 HashMap에 넣기
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        // 완주한 참가자의 카운트 줄이기
        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }

        // 카운트가 0보다 큰 참가자 찾기 (완주하지 않은 참가자)
        for (String key : map.keySet()) {
            if (map.get(key) > 0) {
                answer = key;
                break;
            }
        }

        return answer;
    }
}
