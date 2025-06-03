import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N=  Integer.parseInt(br.readLine());

		int arr[] = new int[N];

		Map<Integer, Integer> map = new HashMap<>();
		for(int i =0 ; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			map.put(arr[i], map.getOrDefault(arr[i], 0) +1);
		}

		int answer[] = new int[N];

		
	

		for(int i =0; i<N ;i++) {
			int cur = arr[i];
			int sq = (int) Math.sqrt(cur);
			if(sq*sq == cur) {
				answer[i] = -map.getOrDefault(sq, 0);
			} else {
				answer[i] = 0;
			}

			for(int j = 1; j<=sq; j++) {
				if(cur%j !=0) {
					continue;
				}
				answer[i] += map.getOrDefault(j, 0) + map.getOrDefault(cur/j, 0);
			}
		} 

		for(int i =0; i<N; i++) {
			System.out.println(answer[i]-1);
		}


	}
	/*
	1 = 2
	2 = 1

	 */
}