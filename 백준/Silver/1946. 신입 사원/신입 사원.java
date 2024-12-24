import java.io.*;
import java.util.*;


class Grade implements Comparable<Grade> {
    int a;
    int b;

    Grade(int a,int b) {
        this.a =a;
        this.b= b;

    }

    @Override
    public int compareTo(Grade o) {
        if(this.a > o.a) 
            return 1;
        return -1;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<T; i++) {
            int N= Integer.parseInt(br.readLine());

            List<Grade> grades = new ArrayList<>();
            for(int j =0; j<N; j++) {
                st = new StringTokenizer(br.readLine());
                grades.add(new Grade(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
            }

            Collections.sort(grades);

            int ans =1;
            int min = grades.get(0).b;
            for(int j =1; j<N; j++) {
                if(grades.get(j).b <min) {
                    ans++;
                    min = grades.get(j).b;
                } 
            }

            sb.append(ans).append("\n");
        }


        System.out.println(sb);
    }

}

