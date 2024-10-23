import java.util.*;
import java.io.*;

public class Main {
    static char arr[];
    static int L, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

     
        Arrays.sort(arr);

     
        solve(0, 0, 0, 0, new StringBuilder());
    }


    public static void solve(int cons, int vowels, int length, int index, StringBuilder currentPassword) {

        if (length == L && cons >= 1 && vowels >= 2) {
            System.out.println(currentPassword.toString());
            return;
        }


        if (index == C) {
            return;
        }

        for (int i = index; i < C; i++) {
            char cur = arr[i];

        
            currentPassword.append(cur);

            if (cur == 'a' || cur == 'e' || cur == 'i' || cur == 'o' || cur == 'u') {
                solve(cons+1, vowels, length + 1, i + 1, currentPassword);
            } else {
                solve(cons, vowels+1, length + 1, i + 1, currentPassword);
            }

            currentPassword.deleteCharAt(currentPassword.length() - 1);
        }
    }
}
