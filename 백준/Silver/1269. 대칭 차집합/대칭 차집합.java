import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i< A; i++) {
            setA.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i< B; i++) {
            setB.add(Integer.parseInt(st.nextToken()));
        }

        int count = 0;
        int answer = 0;
        for(int cur : setA) {
            if(setB.contains(cur)) {
                count ++;
            }
        }

        for(int cur : setB) {
            if(setA.contains(cur)) {
                count ++;
            }
        }

        answer = (A+B) - count;
        System.out.println(answer);
    }
}
