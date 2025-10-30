import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d= Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(c, 1);
        for(int i =0; i<N; i++) {
            int cur = Integer.parseInt(br.readLine());
            if(i<k) {
                map.put(cur, map.getOrDefault(cur, 0)+1);
            }
            list.add(cur);
        }
        int answer= map.keySet().size();
        int start = 0;
        int end = k-1;

        while(true) {
            map.put(list.get(start), map.getOrDefault(list.get(start), 0) -1);
            if(map.get(list.get(start)) <=0) {
                map.remove(list.get(start));
            }

            start+=1;
            end+=1;

            if(start == N) {
                start = 0;
            }
            if(end == N) {
                end = 0;
            }

            map.put(list.get(end), map.getOrDefault(list.get(end), 0)+1);

            answer = Math.max(answer, map.keySet().size());

            if(start ==0 && end == k-1) {
                break;
            }
        }

        System.out.println(answer);
    }
}
// 7 9 30