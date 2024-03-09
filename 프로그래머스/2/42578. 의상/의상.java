import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for (int i = 0; i < clothes.length; i++) {
            String[] str = clothes[i];
            map.put(str[1], map.getOrDefault(str[1], 0) + 1);
        }
        
        for (int value : map.values()) {
            // 각 의상 종류별로 (해당 종류를 입지 않는 경우 포함하여) 조합 수를 계산합니다.
            answer *= (value + 1);
        }
        
        // 모든 의상을 입지 않는 경우를 제외합니다.
        return answer - 1;
    }
}
