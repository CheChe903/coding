import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) 
		{
            int M = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();

            for (int j = 0; j < M; j++) 
			{
                String str = br.readLine();
                String[] cur = str.split(" ");
                String type = cur[1];

                map.put(type, map.getOrDefault(type, 0) + 1);
            }

            int answer = 1;
            for (int count : map.values()) 
			{
	            answer *= (count + 1);
            }

            answer -= 1;

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
