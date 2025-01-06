import java.io.*;
import java.util.*;

public class Main {
    static int N,M,arr[];
    static StringBuilder sb = new StringBuilder();
    static HashSet<String> set;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N =  Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i <N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        set = new HashSet<>();
        Arrays.sort(arr);
        back(0, new ArrayList<>());

        System.out.println(sb);
    }

    static void back(int depth, List<Integer> list) {

        if(depth == M) {
            String curAnswer = "";
            for(int i =0; i<M; i++){
                curAnswer = curAnswer + list.get(i) +" ";
            }
            if(!set.contains(curAnswer)) {
                set.add(curAnswer);
                sb.append(curAnswer).append("\n");
            }
            return;
        }

        for(int i =0; i<N; i++) {
                list.add(arr[i]);
                back(depth+1, list);
                list.remove(list.size()-1);
        }
    }
}
