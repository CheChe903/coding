import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<int[]> list = new ArrayList<>();
        List<Integer> numberList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char[] ch = s.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '{') continue;
            if (Character.isDigit(ch[i])) {
                sb.append(ch[i]);
            } else if (ch[i] == ',') {
                if (sb.length() > 0) {
                    numberList.add(Integer.parseInt(sb.toString()));
                    sb.setLength(0);
                }
            } else if (ch[i] == '}') {
                if (sb.length() > 0) {
                    numberList.add(Integer.parseInt(sb.toString()));
                    sb.setLength(0);
                }
                if (!numberList.isEmpty()) {
                    int[] temp = new int[numberList.size()];
                    for (int j = 0; j < numberList.size(); j++) {
                        temp[j] = numberList.get(j);
                    }
                    list.add(temp);
                    numberList.clear();
                }
            }
        }
        list.sort((o1, o2) -> o1.length - o2.length);

        int[] answer = new int[list.size()];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            for (int num : list.get(i)) {
                if (set.add(num)) {
                    answer[i] = num;
                    break;
                }
            }
        }

        return answer;
    }
}
