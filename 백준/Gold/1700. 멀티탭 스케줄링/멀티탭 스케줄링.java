import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int arr[] = new int[K+1];
        int seq[]=  new int[K+1];
        int answer =0;
        boolean visited[] = new boolean[K+1];
        st = new StringTokenizer(br.readLine());
        for(int i =1; i<=K; i++) {
            int cur = Integer.parseInt(st.nextToken());
            arr[cur]++;
            seq[i] = cur; 
        }

        int remainTap = N;
        
        for(int i =1; i<=K; i++) {
            int cur = seq[i];

            if(remainTap >=1 ) {
                if(visited[cur] == false) {
                    visited[cur] = true;
                    remainTap--;
                }
                else
                    continue;
            }
            else if(remainTap ==0 && visited[cur]== true) 
                continue;
            else if(remainTap==0 && visited[cur]== false) {
                ArrayList<Integer> arrayList= new ArrayList<>();
                for(int j =i; j<=K;j ++) {
                    if(visited[seq[j]] && !arrayList.contains(seq[j])) {
                        arrayList.add(seq[j]);
                    }
                }

                if(arrayList.size()!=N) {
                    for(int j =1; j<=visited.length; j++) {
                        if(visited[j] && !arrayList.contains(j)) {
                            visited[j] =false;
                            break;
                        }
                    }
                }
                else {
                    int remove = arrayList.get(arrayList.size()-1);
                    visited[remove] = false;
                }
                visited[cur] =true;
                answer++;
            }
            
        }

        System.out.println(answer);

    }

}


//2 3
//3 2
//1 1
//7 1

//처음에는 그냥 다 꽂는다. 
//만약 그 애가 꽂혀있는 애면 그냥 넘기고, 
//꽂혀있지 않은 애이면 ? 
//꽂혀있는 것들의 남은 횟수를 구해야 하는데, 이게 위치도 상관이 있네 앞 두개 ? 확인 ? 있는 것들 중 가장 많은 것?
//

