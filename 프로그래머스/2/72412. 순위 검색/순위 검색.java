import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        
        Map<String, ArrayList<Integer>> map = new HashMap<>();
        
        for(String s: info) {
            String[] parts = s.split(" ");
            String[] attrs = new String[]{parts[0], parts[1], parts[2], parts[3]};
            int score = Integer.parseInt(parts[4]);
            
            for(int mask = 0; mask<16; mask++) {
                StringBuilder key = new StringBuilder();
                for(int i =0; i<4; i++) {
                    if(i >0 ) key.append("_");
                    key.append(((mask & (1 << i)) != 0) ? "-" : attrs[i]);
                }
                map.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(score);
            }
        }
        for (ArrayList<Integer> l : map.values()) {
            Collections.sort(l);
        }
        int qIdx = 0;
        
        int answer[] = new int[query.length];
        
        for(String s: query) {
            s = s.replace(" and ", " ");
            String[] parts = s.split(" ");
            String attrs = parts[0] +"_" + parts[1] + "_" +parts[2] + "_"+ parts[3];
            int score = Integer.parseInt(parts[4]);
            ArrayList<Integer> list = map.getOrDefault(attrs, new ArrayList<>());
            int lo = 0, hi = list.size();
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (list.get(mid) < score) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            answer[qIdx] = list.size() - lo;
            qIdx++;
        }
        
        return answer;
    }
}