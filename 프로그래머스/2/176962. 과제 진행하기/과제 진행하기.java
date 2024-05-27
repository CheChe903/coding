import java.util.*;

class Assign {
    String name;
    int start;
    int playtime;
    
    public Assign(String name, int start, int playtime) {
        this.name = name;
        this.start = start;
        this.playtime = playtime;
    }
}

class Solution {
    public String[] solution(String[][] plans) {
        PriorityQueue<Assign> pq = new PriorityQueue<>(new Comparator<Assign>() {
            @Override
            public int compare(Assign o1, Assign o2) {
                return o1.start - o2.start;
            }
        });

        for (int i = 0; i < plans.length; i++) {
            String name = plans[i][0];
            int starthour = Integer.parseInt(plans[i][1].substring(0, 2));
            int startmin = Integer.parseInt(plans[i][1].substring(3, 5));
            int start = starthour * 60 + startmin;
            int playtime = Integer.parseInt(plans[i][2]);
            pq.add(new Assign(name, start, playtime));
        }

        String[] answer = new String[plans.length];
        Stack<Assign> stack = new Stack<>();
        int idx = 0;
        
        while (!pq.isEmpty()) {
            Assign current = pq.poll();

            if (!pq.isEmpty() && pq.peek().start < current.start + current.playtime) {
                int remainingTime = current.playtime - (pq.peek().start - current.start);
                current.playtime = remainingTime;
                stack.push(current);
            } else {
                answer[idx++] = current.name;
                int currentEndTime = current.start + current.playtime;
                
                while (!stack.isEmpty()) {
                    Assign paused = stack.pop();
                    if (pq.isEmpty() || pq.peek().start >= currentEndTime + paused.playtime) {
                        answer[idx++] = paused.name;
                        currentEndTime += paused.playtime;
                    } else {
                        paused.playtime -= (pq.peek().start - currentEndTime);
                        stack.push(paused);
                        break;
                    }
                }
            }
        }

        while (!stack.isEmpty()) {
            answer[idx++] = stack.pop().name;
        }

        return answer;
    }
}
