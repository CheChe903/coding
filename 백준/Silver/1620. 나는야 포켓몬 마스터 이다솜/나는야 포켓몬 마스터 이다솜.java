
import java.io.*;
import java.util.*;
 
public class Main {
 
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N= Integer.parseInt(st.nextToken());

		int M = Integer.parseInt(st.nextToken());

		HashMap<Integer, String> map1 = new HashMap<>();
		HashMap<String, Integer> map2 = new HashMap<>();

		StringBuilder sb = new StringBuilder();

		for(int i =1; i<=N; i++)
		{
			String curpokemon = br.readLine();

			map1.put(i, curpokemon);
			map2.put(curpokemon, i);
			
		}

		for(int i =0; i<M; i++)
		{
			String curInput = br.readLine();
            try {
                int curInputToInteger = Integer.parseInt(curInput);
                if (curInputToInteger >= 1 && curInputToInteger <= N) 
				{
                    sb.append(map1.get(curInputToInteger)).append("\n");
                }
            } catch (NumberFormatException e) {
                if (map2.containsKey(curInput)) 
				{
                    sb.append(map2.get(curInput)).append("\n");
                }
            }
		}

		System.out.println(sb);
 
	}	
 
}