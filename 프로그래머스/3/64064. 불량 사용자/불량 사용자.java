import java.util.*;

class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        List<List<String>> possibleLists = new ArrayList<>();
        
        for (String banned : banned_id) {
            List<String> possibleUsers = new ArrayList<>();
            for (String user : user_id) {
                if (isMatch(banned, user)) {
                    possibleUsers.add(user);
                }
            }
            possibleLists.add(possibleUsers);
        }
        
        Set<Set<String>> resultSet = new HashSet<>();
        findCombinations(possibleLists, new HashSet<>(), 0, resultSet);
        
        return resultSet.size();
    }

    private boolean isMatch(String banned, String user) {
        if (banned.length() != user.length()) {
            return false;
        }
        
        for (int i = 0; i < banned.length(); i++) {
            if (banned.charAt(i) != '*' && banned.charAt(i) != user.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private void findCombinations(List<List<String>> possibleLists, Set<String> currentSet, int idx, Set<Set<String>> resultSet) {
        if (idx == possibleLists.size()) {
            resultSet.add(new HashSet<>(currentSet));
            return;
        }

        for (String user : possibleLists.get(idx)) {
            if (!currentSet.contains(user)) { 
                currentSet.add(user);
                findCombinations(possibleLists, currentSet, idx + 1, resultSet);
                currentSet.remove(user);
            }
        }
    }
}
