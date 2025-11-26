import java.io.*;
import java.util.*;

public class Main {

    static class Road {

        int start;
        int end;
        int cost;

        public Road(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int dp[]= new int[D+1];

        for(int i =1; i<=D; i++) {
            dp[i] = i;
        }
        List<Road> roads= new ArrayList<>();
        for(int i =0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if(end > D) {
                continue;
            }
            if(end - start <= cost) {
                continue;
            }
            roads.add(new Road(start, end, cost));
        }
        roads.sort((r1, r2) -> r1.start - r2.start);
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        int idx = 0;
        for(int i =0; i<D; i++) {

            dp[i+1] =Math.min(dp[i]+1, dp[i+1]);
            
            while(idx < roads.size() && roads.get(idx).start == i) {
                Road road = roads.get(idx);
                dp[road.end] = Math.min(dp[road.end], dp[i] + road.cost);
                idx+=1;
            }
        }
        System.out.println(dp[D]);
    }
}
/*
dp냐, 뭔가 다익스트라나 최소 경로 알고리즘은 아닌 것 같은 느낌인데. 우선순위큐에 담아서 다음 지름길까지 그냥 더하기? 해볼만 한 거 같은데. 왜
아 dp다. 왜냐면 그리디로 탈 수 있는 거 먼저 타도, 뒤에 있는 거로 한 번에 갈 수 잇으니 .. 어 다익스트라가 맞네 ..
그럼 시작을 0에서 한다고 하면 , 0->1, 1->2 이렇게 가야하는 건가? 굳이 ? 아 다익스트라가 애초에 우선순위 큐에서 가장 비용이 낮은 걸 기준으로 하는 거지. 그렇다면 만약 0에서 시작하는 지름 길이 없다고 해보자.

만약 100까지 가야함. 근데   10 ->50 10이 있고, 70 -> 90 10이 있다고 했을 때, 0,10 10,50, 50,70, 70,90, 90 100 이렇게 가야하는데, 지름길이 없는 경우는 어떻게 해야할지 ..... 흠 . 만약 통과한 지름길이 있다면 그것을 넣어놔야하나 ?우선순위 큐에

0~150까지 dp 만들고, 각 크기만큼 넣어놓은 뒤, 순회? 0~50 이면 50을 10으로 바꾼다음 10부터 150까지 또 업뎃 ? 
그 다음 0 ~50 또 떴을때 20이니까 pass 그다음 50~100까지 10이니까 100 확인 후 바꾸고 100~150업뎃 100 151 151은 넘으니 pass 
dp[1] = 1; dp[2] = 2; dp[3] = 3; .. dp[30] = 10
*/
