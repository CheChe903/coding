import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Comparator<String> cmp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] a1 = o1.split("-");
                String[] a2 = o2.split("-");

                // 1) 알파벳 부분 비교
                int alphaCompare = a1[0].compareTo(a2[0]);
                if (alphaCompare != 0) {
                    return alphaCompare;
                }
                // 2) 알파벳이 같으면 숫자 크기 비교
                int num1 = Integer.parseInt(a1[1]);
                int num2 = Integer.parseInt(a2[1]);
                return Integer.compare(num1, num2);
            }
        };

		Queue<String> queue = new LinkedList<>();
		Queue<String> pq= new PriorityQueue<>(cmp);
		int N = Integer.parseInt(br.readLine());

		Stack<String> stack = new Stack<>();
		for(int i =0; i<N; i++) {
			String[] inputs = br.readLine().split(" ");

			for(int j = 0; j<5; j++) {
				queue.add(inputs[j]);
				pq.offer(inputs[j]);
			}
		}


		while(!pq.isEmpty()) {
			if(!stack.isEmpty()) {
				if(stack.peek().equals(pq.peek())) {
					stack.pop();
					pq.poll();
					continue;
				} 
			}
			if(!queue.isEmpty()) {
				if(queue.peek().equals(pq.peek())) {
					queue.poll();
					pq.poll();
					continue;
				}
				else {
					String cur = queue.poll();

					if(!stack.isEmpty()) {
						String s1 = stack.peek();
						String s2 = cur;

						if(cmp.compare(s1, s2) < 0) {
							System.out.println("BAD");
							return;
						}
					}
					stack.add(cur);
				}
			} else {
				System.out.println("BAD");
				return;
			}
		}
		System.out.println("GOOD");


	}
}