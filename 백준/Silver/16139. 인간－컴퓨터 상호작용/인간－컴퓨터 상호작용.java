import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        int question = Integer.parseInt(br.readLine());

        int check[][] = new int[26][2001];

        for(int i =0; i<S.length(); i++) {
            char currentChar = S.charAt(i);

            for(int j = i; j<S.length(); j++) {
                check[currentChar -'a'][j]++;
            }
        }

        StringBuilder sb=  new StringBuilder();
        StringTokenizer st;
        for(int q= 0; q<question; q++) {
            st = new StringTokenizer(br.readLine());

            char a = st.nextToken().charAt(0);

            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            if(l ==0) {
                sb.append(check[a-'a'][r]).append("\n");

            }
            else
            sb.append(check[a-'a'][r] - check[a-'a'][l-1]).append("\n");

        }
        System.out.println(sb);
    }
}