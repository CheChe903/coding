import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String regex = "(100+1+|01)+";

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i =0; i<N; i++) {
            String input = br.readLine();

            if(Pattern.matches(regex, input)) {
                sb.append("YES");            
            }
            else
                sb.append("NO");
            sb.append("\n");
        }

        System.out.println(sb);

    }
}