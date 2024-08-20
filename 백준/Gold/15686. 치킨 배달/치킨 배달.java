import java.io.*;
import java.util.*;

public class Main {

    static int [][]arr;
    static ArrayList<int[]> house = new ArrayList<>();
    static ArrayList<int[]> chicken = new ArrayList<>();
    static ArrayList<int[]> choice = new ArrayList<>();
    static int result = Integer.MAX_VALUE;
    static boolean[] visit;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        


        arr = new int [N][N];

        for(int i =0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if(arr[i][j] == 1)
                    house.add(new int[] {i,j});
                else if(arr[i][j] ==2)
                    chicken.add(new int[]{i,j}); 
            }
        }

        visit = new boolean[chicken.size()];

        backtracking(0,0);
        System.out.println(result);
    }

    static void backtracking(int depth, int start) {
        if(depth == M) {
            int sum =0;
            for(int[] h : house) {
                int min = Integer.MAX_VALUE;
                for(int [] c : choice) {
                    int d = Math.abs(h[0]-c[0]) + Math.abs(h[1]- c[1]);
                    min = Math.min(d,min);
                }
                sum +=min;
            }
            result = Math.min(result,sum);
            return;
        }


        for(int i =start; i< chicken.size(); i++) {
            if(!visit[i]) {
                visit[i]= true;
                choice.add(chicken.get(i));
                backtracking(depth+1, i +1);

                choice.remove(choice.size()-1);

                visit[i]= false;
            }
        }
    }

}