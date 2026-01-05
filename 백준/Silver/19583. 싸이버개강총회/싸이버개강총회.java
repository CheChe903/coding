import java.io.*;
import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        LocalTime S = LocalTime.parse(st.nextToken());
        LocalTime E = LocalTime.parse(st.nextToken());
        LocalTime Q = LocalTime.parse(st.nextToken());

        Set<String> before = new HashSet<>();
        int answer = 0;

        String line;
        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            LocalTime time = LocalTime.parse(st.nextToken());
            String user = st.nextToken();

            if (!time.isAfter(S)) {
                before.add(user);
            }

            else if (!time.isBefore(E) && !time.isAfter(Q) && before.contains(user)) {
                answer++;
                before.remove(user);
            }
        }

        System.out.println(answer);
    }
}
