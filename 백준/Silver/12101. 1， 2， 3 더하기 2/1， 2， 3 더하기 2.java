import java.io.*;
import java.util.*;



public class Main {
    static int order;
    static int n,k;
    static boolean found;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        order = 0;
        found = false;
        back(0, new ArrayList<>());
        if(!found) System.out.print(-1);
    }

    static void back(int sum, ArrayList<Integer> now) {
        if(found) return;  // 이미 찾았으면 더 이상 진행하지 않음
        
        if(sum == n) {
            order++;
            if(order == k) {
                found = true;
                for(int i = 0; i < now.size()-1; i++) {
                    System.out.print(now.get(i) + "+");
                }
                System.out.print(now.get(now.size()-1));
            }
            return;
        }
        
        if(sum > n) return;
        
        // 사전순으로 1, 2, 3을 시도
        for(int i = 1; i <= 3; i++) {
            ArrayList<Integer> next = new ArrayList<>(now);
            next.add(i);
            back(sum + i, next);
        }
    }
}