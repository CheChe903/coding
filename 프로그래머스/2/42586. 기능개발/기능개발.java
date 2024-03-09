import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> stack = new Stack<>();
        int cur = 0;

        while (cur < progresses.length) {
            int ans = 0;

            // 작업 진행률이 100이 될 때까지 각 작업을 진행
            while (cur < progresses.length && progresses[cur] < 100) {
                for (int i = cur; i < progresses.length; i++) {
                    progresses[i] += speeds[i];
                }
            }

            // 100이 넘은 작업 수 세기
            while (cur < progresses.length && progresses[cur] >= 100) {
                cur++;
                ans++;
            }

            // 완료된 작업 수를 스택에 추가
            stack.push(ans);
        }

        // 스택에서 값을 꺼내서 배열에 저장
        int[] answer = new int[stack.size()];
        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }
}
