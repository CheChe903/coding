import java.io.*;
import java.util.*;

public class Main {
    static int answer,N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        N = Integer.parseInt(br.readLine());

        List<int []> list = new ArrayList<>();
        StringTokenizer st;
        for(int i =0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            int S = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            list.add(new int[]{S,W});
        }

        back(0, 0, list);

        System.out.println(answer);
    }

    static void back(int curIndex, int value, List<int[]> list) {
        if(curIndex == N) {
            answer = Math.max(answer, value);
            return;
        }
        answer = Math.max(answer, value);
        
        int realCurIndex = curIndex;
        int realValue = value;
        for(int i = curIndex; i<N; i++) {
            if(list.get(i)[0] >=1) {
                realCurIndex = i;
                break;
            }
        }

        if(list.get(realCurIndex)[0] <=0) {
            return;
        }


        for(int i =0; i<N; i++) {
            if(realCurIndex == i) continue;

            if(list.get(i)[0] >=1) {
                list.get(realCurIndex)[0] -= list.get(i)[1];
                list.get(i)[0] -= list.get(realCurIndex)[1];
                if(list.get(realCurIndex)[0] <=0 && list.get(i)[0] <=0) {
                    back(realCurIndex+1, realValue+2, list);
                }
                else if(list.get(realCurIndex)[0] <=0) {
                    back(realCurIndex+1, realValue+1, list);
                }
                else if (list.get(i)[0] <=0) {
                    back(realCurIndex+1, realValue+1, list);
                }
                else {
                    back(realCurIndex+1, realValue, list);    
                }
                list.get(realCurIndex)[0] += list.get(i)[1];
                list.get(i)[0] += list.get(realCurIndex)[1];
            }
        }
    } 
}
