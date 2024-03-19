import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        LinkedHashMap<String, String> hash = new LinkedHashMap<>();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < record.length; i++) {
            String[] mystr = record[i].split(" ");
            if (mystr[0].equals("Enter")) {
                hash.put(mystr[1], mystr[2]);
                list.add(mystr[1] + ":Enter");
            } else if (mystr[0].equals("Leave")) {
                list.add(mystr[1] + ":Leave");
            } else if (mystr[0].equals("Change")) {
                hash.put(mystr[1], mystr[2]);
            }
        }

        String[] answer = new String[list.size()];
        int cur = 0;
        for (String str : list) {
            String[] good = str.split(":");
            if (good[1].equals("Enter"))
                answer[cur] = hash.get(good[0]) + "님이 들어왔습니다.";
            else if (good[1].equals("Leave"))
                answer[cur] = hash.get(good[0]) + "님이 나갔습니다.";
            cur++;
        }

        return answer;
    }
}
