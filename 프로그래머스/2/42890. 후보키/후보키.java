import java.util.*;
class Solution {
    List<Set<Integer>> candidate = new ArrayList<>();
    public int solution(String[][] relation) {
        
        for(int i = 1; i <= relation[0].length; i++) {
            back(i, 0, 0, relation, new boolean[relation[0].length]);
        }
        return candidate.size();
    }
    
    public void back(int target, int start, int depth, String [][] relation, boolean [] visited) {
        
        if(depth == target) {
            List<Integer> cols = new ArrayList<>();
            
            for(int i = 0; i < visited.length; i++) {
                if(visited[i]) {
                    cols.add(i);
                }
            }
            if(isUnique(cols, relation) && isMin(cols)) {
                candidate.add(new HashSet<>(cols));
            }            
        }
        
        
        for(int i = start; i < relation[0].length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                back(target, i+1, depth+1, relation, visited);
                visited[i] = false;
            }
        }
    }
    
    public boolean isUnique(List<Integer> cols, String[][] relation) {
        Set<String> tuples = new HashSet<>();
        for(String row[] : relation) {
            StringBuilder sb = new StringBuilder();
            for(int nums : cols) {
                sb.append(row[nums]).append("|");    
            }            
            tuples.add(sb.toString());
        }
        return tuples.size() == relation.length;
        
    }
    
    public boolean isMin(List<Integer> cols) {
        for(Set<Integer> can : candidate) {
            Set<Integer> colsSet = new HashSet<>(cols);
            
            if(colsSet.containsAll(can)) {
                return false;
            }
        }
        return true;
    }
}