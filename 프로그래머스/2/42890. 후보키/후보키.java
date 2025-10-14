import java.util.*;

class Solution {
    List<Set<Integer>> candidateKeys = new ArrayList<>();

    public int solution(String[][] relation) {
        int colCount = relation[0].length;
        boolean[] visited = new boolean[colCount];

        for (int r = 1; r <= colCount; r++) { // 조합 크기 1~N
            backtrack(0, 0, r, relation, visited);
        }

        return candidateKeys.size();
    }

    public void backtrack(int depth, int start, int target, String[][] relation, boolean[] visited) {
        if (depth == target) {
            List<Integer> cols = new ArrayList<>();
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) cols.add(i);
            }

            if (isUnique(cols, relation) && isMinimal(cols)) {
                candidateKeys.add(new HashSet<>(cols));
            }
            return;
        }

        for (int i = start; i < relation[0].length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtrack(depth + 1, i + 1, target, relation, visited);
                visited[i] = false;
            }
        }
    }

    private boolean isUnique(List<Integer> cols, String[][] relation) {
        Set<String> tuples = new HashSet<>();
        for (String[] row : relation) {
            StringBuilder sb = new StringBuilder();
            for (int c : cols) sb.append(row[c]).append("|");
            tuples.add(sb.toString());
        }
        return tuples.size() == relation.length;
    }

    private boolean isMinimal(List<Integer> cols) {
        Set<Integer> current = new HashSet<>(cols);
        for (Set<Integer> key : candidateKeys) {
            if (current.containsAll(key)) return false;
        }
        return true;
    }
}
