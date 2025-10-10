import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int [] clearStage = new int[N+1];
        int [] failStage = new int[N+1];
        int answer[] = new int[N];
        for(int i =0; i<stages.length; i++) {
            for(int j =0; j<stages[i];j++) {
                clearStage[j]+=1;
            }
            failStage[stages[i]-1]+=1;
        }
        
        Map<Integer, Double> map = new HashMap<>();
        
        for(int i =0; i<N; i++) {
            if(clearStage[i] ==0 || failStage[i] == 0) {
                map.put(i+1, 0.0);
            }
            else {
                map.put(i+1, (double) failStage[i]/ (double) clearStage[i]);
            }
        }
        List<Integer> list = new ArrayList<>(map.keySet());

        list.sort((o1, o2) -> Double.compare(map.get(o2), map.get(o1)));

        return list.stream().mapToInt(i -> i).toArray();
    
    }
}