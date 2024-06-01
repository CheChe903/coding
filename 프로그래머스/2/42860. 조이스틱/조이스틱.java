class Solution {
    public int solution(String name) {
        int n = name.length();
        int answer = 0;

        // 각 문자를 변경하는 데 필요한 최소 조작 횟수 계산
        for (int i = 0; i < n; i++) {
            char charAt = name.charAt(i);
            answer += Math.min(charAt - 'A', 'Z' - charAt + 1);
        }

        // 커서 이동을 위한 최소 조작 횟수 계산
        int move = n - 1;
        for (int i = 0; i < n; i++) {
            int nextIdx = i + 1;
            while (nextIdx < n && name.charAt(nextIdx) == 'A') {
                nextIdx++;
            }
            move = Math.min(move, i + n - nextIdx + Math.min(i, n - nextIdx));
        }

        answer += move;
        return answer;
    }
}
