import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        int question = Integer.parseInt(br.readLine());

        int check[][] = new int[26][S.length()+1];

        for(int i =0; i<S.length(); i++) {
            for(int j = 0; j<26; j++) {
                check[j][i+1] = check[j][i];
            }
            check[S.charAt(i)-'a'][i+1]++;
        }

        StringBuilder sb=  new StringBuilder();
        StringTokenizer st;
        for(int q= 0; q<question; q++) {
            st = new StringTokenizer(br.readLine());

            char a = st.nextToken().charAt(0);

            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            sb.append(check[a-'a'][r+1] - check[a-'a'][l]).append("\n");

        }
        System.out.println(sb);
    }
}