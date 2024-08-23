import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            set.add(str);
        }

        ArrayList<String> answer = new ArrayList<>();
        
        for(int i =0; i<M; i++) {
            String str = br.readLine();

            if(set.contains(str)) {
                answer.add(str);
            }
        }

        Collections.sort(answer);

        System.out.println(answer.size());

        for(String s : answer) 
            System.out.println(s);
    }
}